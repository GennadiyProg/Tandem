package org.example.model;

public class Palindrome {
    private int id;
    private String phrase;

    public Palindrome(String phrase) {
        this.phrase = phrase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
