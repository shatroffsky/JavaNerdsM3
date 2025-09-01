package com.codegym.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codegym.exception.UserNotFoundException;
import com.codegym.exception.UserValidationException;
import com.codegym.model.User;
import com.codegym.repository.UserRepository;

public class UserService {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
  private static final String USER_NOT_FOUND = "User with %s %s not found";
  private final UserRepository userRepository;
  private final UserValidator userValidator;

  public UserService(UserRepository userRepository, UserValidator userValidator) {
    this.userRepository = userRepository;
    this.userValidator = userValidator;
  }

  public User getByEmail(String email) {
    userValidator.validateEmail(email);
    return userRepository.findByEmail(email).orElseThrow(() ->
        new UserNotFoundException(USER_NOT_FOUND.formatted("email", email)));
  }

  public User getById(Long id) {
    userValidator.validateId(id);
    return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND.formatted("id", id)));
  }

  public List<User> findByName(String name) {
    LOGGER.info("Finding users by name {}", name);
    userValidator.validateName(name);
    return userRepository.findByName(name);
  }

  public void save(User user) {
    userValidator.validateUser(user);
    userRepository.save(user);
  }

  public void doThrowException() {
    try {
      throw new Exception("Invalid user");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      LOGGER.error("Threw exception during... {}", e.getCause().getMessage());
    }
  }

}
