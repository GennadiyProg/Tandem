package org.example.dao;

import org.example.model.Palindrome;

import java.util.Optional;

public interface PalindromeDao {
    Palindrome save(Palindrome palindrome);

    Optional<Palindrome> findByPhrase(String phrase);
}
