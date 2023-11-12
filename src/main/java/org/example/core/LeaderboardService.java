package org.example.core;

import org.example.model.Leader;
import org.example.model.User;

import java.util.List;

public interface LeaderboardService {
    List<Leader> get();

    boolean addNewPotentialLeader(User user);
}
