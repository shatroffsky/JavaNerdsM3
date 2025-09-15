package com.codegym.web.servlets;

import com.codegym.web.repository.InMemoryUserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {

    private final InMemoryUserRepository userRepository;

    public UserDeleteServlet(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = getIdFromRequest(req);
        userRepository.delete(id);

        req.setAttribute("users", userRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(req, resp);
    }

    private Long getIdFromRequest(HttpServletRequest req) {
        String idStr = req.getParameter("id");
        if (idStr == null || idStr.isBlank()) {
            throw new IllegalArgumentException("Missing 'id' parameter");
        }
        return Long.valueOf(idStr);
    }
}
