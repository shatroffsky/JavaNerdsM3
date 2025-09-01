package com.codegym.repository;


import java.util.List;
import java.util.Optional;
import com.codegym.model.User;

public interface UserRepository {

  Optional<User> findById(Long id);

  List<User> findByName(String name);

  Optional<User> findByEmail(String email);

  void save(User user);

}
