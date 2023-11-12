package org.example.client;

import org.example.core.PalindromeService;
import org.example.core.UserService;
import org.example.model.User;

import java.util.Optional;

import static org.example.core.Algorithms.normalizePhrase;

public class Tandem {
    private final UserService userService;
    private final PalindromeService palindromeService;

    public Tandem(UserService userService, PalindromeService palindromeService) {
        this.userService = userService;
        this.palindromeService = palindromeService;
    }

    public User input(String userName, String phrase) {
        String clientPhrase = normalizePhrase(phrase);
        if (!palindromeService.check(clientPhrase)) {
            return null;
        }
        String clientUserName = userName.trim();

        Optional<User> foundedUser = userService.findByName(clientUserName);
        User user = foundedUser.orElseGet(() -> userService.create(clientUserName));
        if (!userService.checkPhraseExists(user, clientPhrase)) {
            user = userService.addPhrase(user, clientPhrase);
        }
        return user;
    }
}
