package com.codegym.web.servlets;

import java.io.IOException;
import com.codegym.web.repository.InMemoryUserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserUpdateServlet extends HttpServlet {
  private final InMemoryUserRepository userRepository;

  public UserUpdateServlet(InMemoryUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }


}
