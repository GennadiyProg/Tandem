package org.example.core;

import org.example.model.User;

import java.util.Optional;

public interface UserService {
    User create(String userName);

    Optional<User> findByName(String name);

    boolean checkPhraseExists(User user, String phrase);

    User addPhrase(User user, String phrase);
}
