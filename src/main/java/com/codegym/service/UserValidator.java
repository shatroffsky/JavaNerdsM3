package com.codegym.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codegym.exception.UserValidationException;
import com.codegym.model.User;

public class UserValidator {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserValidator.class);

  public void validateId(Long id) {
    if (id == null || id <= 0) {
      LOGGER.error("Invalid id {}. Please enter a valid id.", id);
      throw new UserValidationException("Invalid id");
    }
  }

  public void validateEmail(String email) {
    if (checkEmail(email)) {
      LOGGER.error("Invalid email. Please enter a valid email.");
      throw new UserValidationException("Invalid email");
    }
  }

  public void validateName(String name) {
    if (checkName(name)) {
      LOGGER.error("Invalid name {}. Please enter a valid name.", name);
      throw new UserValidationException("Invalid name");
    }
  }

  public void validateUser(User user) {
    if (user == null) {
      LOGGER.error("User is null. Please enter a valid user.");
      throw new UserValidationException("Invalid payload");
    }

    if (user.getId() == null) {
      LOGGER.error("User's id is null. Please enter a valid id.");
      throw new UserValidationException("Invalid id");
    }

    if (checkEmail(user.getEmail())) {
      LOGGER.error("Invalid email. Please enter a valid email.");
      throw new UserValidationException("Invalid email");
    }

    if (checkName(user.getName())) {
      LOGGER.error("Invalid name. Please enter a valid name.");
      throw new UserValidationException("Invalid name");
    }


  }

  private boolean checkEmail(String email) {
    return email == null || !email.contains("@");
  }

  private boolean checkName(String name) {
    return name == null || name.length() < 3;
  }


}
