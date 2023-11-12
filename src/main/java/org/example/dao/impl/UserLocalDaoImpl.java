package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserLocalDaoImpl implements UserDao {
    private final List<User> users;

    public UserLocalDaoImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        Optional<User> foundedUser = findByName(user.getName());
        if (foundedUser.isEmpty()) {
            return save(user);
        } else {
            foundedUser.get().setPalindromes(user.getPalindromes());
            foundedUser.get().setScore(user.getScore());
            return foundedUser.get();
        }
    }

    @Override
    public Optional<User> findByName(String userName) {
        return users.stream().filter(user -> user.getName().equals(userName)).findFirst();
    }
}
