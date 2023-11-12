package org.example.core;

public class Algorithms {
    public static boolean checkPalindrome(String phrase) {
        phrase = normalizePhrase(phrase);
        int length = phrase.length();
        for(int i = 0; i < length/2; i++) {
            if(phrase.charAt(i) != phrase.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static String normalizePhrase(String phrase) {
        return phrase.replaceAll(" ", "").toLowerCase();
    }
}
