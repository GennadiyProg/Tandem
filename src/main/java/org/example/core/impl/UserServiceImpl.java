package org.example.core.impl;

import org.example.core.LeaderboardService;
import org.example.core.PalindromeService;
import org.example.core.UserService;
import org.example.dao.UserDao;
import org.example.model.Palindrome;
import org.example.model.User;

import java.util.ArrayList;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PalindromeService palindromeService;
    private final LeaderboardService leaderboardService;

    public UserServiceImpl(UserDao userDao, PalindromeService palindromeService, LeaderboardService leaderboardService) {
        this.userDao = userDao;
        this.palindromeService = palindromeService;
        this.leaderboardService = leaderboardService;
    }

    @Override
    public User create(String userName) {
        User user = new User(userName);
        return userDao.save(user);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public boolean checkPhraseExists(User user, String phrase) {
        if (user.getPalindromes() == null || user.getPalindromes().isEmpty()) {
            return false;
        } else {
            Optional<Palindrome> contained = user.getPalindromes()
                    .stream()
                    .filter(palindrome -> palindrome.getPhrase().equals(phrase))
                    .findFirst();
            return contained.isPresent();
        }
    }

    @Override
    public User addPhrase(User user, String phrase) {
        if (user.getPalindromes() == null) {
            user.setPalindromes(new ArrayList<>());
        }
        Optional<Palindrome> foundedPalindrome = palindromeService.findByPhrase(phrase);
        Palindrome palindrome = foundedPalindrome.orElseGet(() -> palindromeService.save(phrase));

        user.getPalindromes().add(palindrome);
        user.setScore(user.getScore() + palindrome.getPhrase().length());
        user = userDao.update(user);

        leaderboardService.addNewPotentialLeader(user);
        return user;
    }
}
