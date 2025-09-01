package com.codegym.web.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.codegym.web.model.User;

public class InMemoryUserRepository {
  private final Map<Long, User> db = new HashMap<>();
  private static Long idsCounter = 0L;

  public List<User> findAll() {
    return new ArrayList<>(db.values());
  }

  public Optional<User> findById(Long id) {
    return Optional.ofNullable(db.get(id));
  }

  public User save(User user) {
    long id = ++idsCounter;
    user.setId(id);
    db.put(id, user);
    return user;
  }

  public boolean delete(Long id) {
    return db.remove(id) != null;
  }

  public boolean update(User user) {
    Long id = user.getId();
    if (id == null || !db.containsKey(id)) {
      return false;
    }
    db.put(id, user);
    return true;
  }

  public static Long getIdsCounter() {
    return ++idsCounter;
  }
}
