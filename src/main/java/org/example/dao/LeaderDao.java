package org.example.dao;

import org.example.model.Leader;

import java.util.List;

public interface LeaderDao {
    List<Leader> save(List<Leader> leaderboard);

    List<Leader> findAll();
}
