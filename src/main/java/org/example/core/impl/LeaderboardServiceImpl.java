package org.example.core.impl;

import org.example.core.LeaderboardService;
import org.example.dao.LeaderDao;
import org.example.model.Leader;
import org.example.model.User;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparingInt;

public class LeaderboardServiceImpl implements LeaderboardService {
    private final LeaderDao leaderDao;

    public LeaderboardServiceImpl(LeaderDao leaderboardDao) {
        this.leaderDao = leaderboardDao;
    }

    @Override
    public List<Leader> get() {
        return leaderDao.findAll();
    }

    @Override
    public boolean addNewPotentialLeader(User user) {
        List<Leader> leaderboard = leaderDao.findAll();
        if (leaderboard.isEmpty()) {
            Leader newLeader = new Leader((short)1, user.getName(), user.getScore());
            leaderboard.add(newLeader);
            leaderDao.save(leaderboard);
            return true;
        } else {
            if (leaderboard.size() < 5 || leaderboard.get(leaderboard.size() - 1).getScore() < user.getScore()) {
                Optional<Leader> existingLeader;
                existingLeader = leaderboard
                        .stream()
                        .filter(leader -> leader.getUserName().equals(user.getName()))
                        .findFirst();
                Leader leader;
                if (existingLeader.isPresent()) {
                    leader = existingLeader.get();
                    leader.setScore(user.getScore());
                } else {
                    leader = new Leader(user.getName(), user.getScore());
                    leaderboard.add(leader);
                }
                constructLeaderboard(leaderboard);
                leaderDao.save(leaderboard);
                return true;
            } else {
                return false;
            }
        }
    }

    private void constructLeaderboard(List<Leader> leaders) {
        leaders.sort(comparingInt(Leader::getScore).reversed());
        for (int i = 0; i < leaders.size(); i++) {
            Leader leader = leaders.get(i);
            leader.setPlace((short)(i + 1));
        }
        if (leaders.size() > 5) {
            leaders.remove(5);
        }
    }
}
