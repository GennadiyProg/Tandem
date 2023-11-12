package org.example.dao.impl;

import org.example.dao.PalindromeDao;
import org.example.model.Palindrome;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PalindromeLocalDaoImpl implements PalindromeDao {
    private final List<Palindrome> palindromes;

    public PalindromeLocalDaoImpl() {
        this.palindromes = new ArrayList<>();
    }

    @Override
    public Palindrome save(Palindrome palindrome) {
        Optional<Palindrome> stored = palindromes.stream()
                .filter(p -> p.getPhrase().equals(palindrome.getPhrase()))
                .findFirst();
        if (stored.isPresent()) {
            return stored.get();
        }
        int id = 0;
        if (!palindromes.isEmpty()) {
            id = palindromes.get(palindromes.size() - 1).getId() + 1;
        }
        palindrome.setId(id);
        palindromes.add(palindrome);
        return palindrome;
    }

    @Override
    public Optional<Palindrome> findByPhrase(String phrase) {
        return palindromes.stream().filter(p -> p.getPhrase().equals(phrase)).findFirst();
    }
}
