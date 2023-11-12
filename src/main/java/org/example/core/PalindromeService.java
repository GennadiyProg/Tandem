package org.example.core;

import org.example.model.Palindrome;

import java.util.Optional;

public interface PalindromeService {
    boolean check(String phrase);

    Palindrome save(String phrase);

    Optional<Palindrome> findByPhrase(String phrase);
}
