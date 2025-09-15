package com.codegym.web.servlets;

import com.codegym.web.model.User;
import com.codegym.web.repository.InMemoryUserRepository;
import com.codegym.exception.UserNotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserEditServlet extends HttpServlet {

    private final InMemoryUserRepository userRepository;

    public UserEditServlet(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = getIdFromRequest(req);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));

        req.setAttribute("mode", "edit");
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/jsp/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = bindUser(req);
        if (!userRepository.update(user)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        req.setAttribute("users", userRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(req, resp);
    }

    private User bindUser(HttpServletRequest req) {
        Long id = getIdFromRequest(req);
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));

        return new User(id, firstName, lastName, email, age);
    }

    private Long getIdFromRequest(HttpServletRequest req) {
        String idStr = req.getParameter("id");
        if (idStr == null || idStr.isBlank()) {
            throw new IllegalArgumentException("Missing 'id' parameter");
        }
        return Long.valueOf(idStr);
    }
}
