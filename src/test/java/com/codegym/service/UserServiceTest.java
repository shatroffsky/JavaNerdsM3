package com.codegym.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import com.codegym.exception.UserNotFoundException;
import com.codegym.exception.UserValidationException;
import com.codegym.model.User;
import com.codegym.repository.UserRepository;

class UserServiceTest {

  private final User USER = new User(1L, "name", "email@");

  private final UserRepository userRepository = mock(UserRepository.class);

  private final UserValidator userValidator = new UserValidator();

  private final UserService classUnderTest = new UserService(userRepository, userValidator);

  @Test
  public void shouldGetByEmail() {
    String email = "email@com";

    when(userRepository.findByEmail(email)).thenReturn(Optional.of(USER));
    User byEmail = classUnderTest.getByEmail(email);

    assertEquals(USER, byEmail);
  }

  @Test
  public void shouldThrowExceptionWhenGetByEmail() {
    String email = "email@com1";
    when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

    assertThrows(UserNotFoundException.class, () -> classUnderTest.getByEmail(email));
  }

  @Test
  public void shouldThrowExceptionWhenInvalidEmail() {
    assertThrows(UserValidationException.class, () -> classUnderTest.getByEmail("value"));
  }

  @Test
  public void shouldThrowExceptionWhenEmailNull() {
    assertThrows(UserValidationException.class, () -> classUnderTest.getByEmail(null));
  }

  @Test
  public void shouldFindByName() {
    String name = "users";

    List<User> users = List.of(USER);

    when(userRepository.findByName(name)).thenReturn(users);

    List<User> byName = classUnderTest.findByName(name);

    assertEquals(1, byName.size());
    assertEquals(USER, byName.get(0));
    assertEquals(users, byName);
  }

  @Test
  public void shouldSaveUser() {
    classUnderTest.save(USER);

    verify(userRepository).save(USER);
  }

}