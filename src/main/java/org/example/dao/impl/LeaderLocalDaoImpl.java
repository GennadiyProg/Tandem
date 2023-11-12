package org.example.dao.impl;

import org.example.dao.LeaderDao;
import org.example.model.Leader;

import java.util.ArrayList;
import java.util.List;

public class LeaderLocalDaoImpl implements LeaderDao {
    private final List<Leader> leaderboard;

    public LeaderLocalDaoImpl() {
        this.leaderboard = new ArrayList<>();
    }

    @Override
    public List<Leader> save(List<Leader> newLeaderboard) {
        leaderboard.clear();
        leaderboard.addAll(newLeaderboard);
        return new ArrayList<>(leaderboard);
    }

    @Override
    public List<Leader> findAll() {
        return new ArrayList<>(leaderboard);
    }
}
