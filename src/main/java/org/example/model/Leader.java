package org.example.model;

public class Leader {
    private short place;
    private String userName;
    private int score;

    public Leader(short place, String userName, int score) {
        this.place = place;
        this.userName = userName;
        this.score = score;
    }

    public Leader(String userName, int score) {
        this.userName = userName;
        this.score = score;
    }

    public short getPlace() {
        return place;
    }

    public void setPlace(short place) {
        this.place = place;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Leader{" +
                "place=" + place +
                ", userName='" + userName + '\'' +
                ", score=" + score +
                '}';
    }
}
