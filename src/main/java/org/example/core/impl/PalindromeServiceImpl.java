package org.example.core.impl;

import org.example.core.PalindromeService;
import org.example.dao.PalindromeDao;
import org.example.model.Palindrome;

import java.util.Optional;

import static org.example.core.Algorithms.checkPalindrome;

public class PalindromeServiceImpl implements PalindromeService {
    private final PalindromeDao palindromeDao;

    public PalindromeServiceImpl(PalindromeDao palindromeDao) {
        this.palindromeDao = palindromeDao;
    }

    @Override
    public boolean check(String phrase) {
        return checkPalindrome(phrase);
    }

    @Override
    public Palindrome save(String phrase) {
        return palindromeDao.save(new Palindrome(phrase));
    }

    @Override
    public Optional<Palindrome> findByPhrase(String phrase) {
        return palindromeDao.findByPhrase(phrase);
    }
}
