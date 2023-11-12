package org.example;

import org.example.client.Tandem;
import org.example.core.LeaderboardService;
import org.example.core.PalindromeService;
import org.example.core.UserService;
import org.example.core.impl.LeaderboardServiceImpl;
import org.example.core.impl.PalindromeServiceImpl;
import org.example.core.impl.UserServiceImpl;
import org.example.dao.LeaderDao;
import org.example.dao.PalindromeDao;
import org.example.dao.UserDao;
import org.example.dao.impl.LeaderLocalDaoImpl;
import org.example.dao.impl.PalindromeLocalDaoImpl;
import org.example.dao.impl.UserLocalDaoImpl;
import org.example.model.Leader;
import org.example.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Hello and welcome!\n");

        PalindromeDao palindromeDao = new PalindromeLocalDaoImpl();
        UserDao userDao = new UserLocalDaoImpl();
        LeaderDao leaderDao = new LeaderLocalDaoImpl();
        PalindromeService palindromeService = new PalindromeServiceImpl(palindromeDao);
        LeaderboardService leaderboardService = new LeaderboardServiceImpl(leaderDao);
        UserService userService = new UserServiceImpl(userDao, palindromeService, leaderboardService);
        Tandem client = new Tandem(userService, palindromeService);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 5; i++) {
            System.out.print("Имя: ");
            String userName = console.readLine();
            System.out.print("Палиндром: ");
            String palindrome = console.readLine();

            User user = client.input(userName, palindrome);
            System.out.println(user != null ? user.toString() : "Фраза не является палиндромом и указанный пользователь ранее не работал с системой");
        }
        System.out.println("Leaderboard:");
        List<Leader> leaderboard = leaderboardService.get();
        leaderboard.forEach(System.out::println);
    }
}