package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Palindrome> palindromes;
    private int score;

    public User(String name) {
        this.name = name;
        this.palindromes = new ArrayList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Palindrome> getPalindromes() {
        return palindromes;
    }

    public void setPalindromes(List<Palindrome> palindromes) {
        this.palindromes = palindromes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder phrases = new StringBuilder("[");
        if (palindromes != null && !palindromes.isEmpty()) {
            palindromes.forEach(palindrome -> phrases.append(palindrome.getPhrase()).append(", "));
            phrases.delete(phrases.length() - 2, phrases.length());
        }
        phrases.append("]");
        return "User{" +
                "name='" + name + '\'' +
                ", palindromes=" + phrases +
                ", score=" + score +
                '}';
    }
}
