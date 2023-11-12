package org.example.dao;

import org.example.model.User;

import java.util.Optional;

public interface UserDao {
    User save(User user);

    User update(User user);

    Optional<User> findByName(String userName);
}
