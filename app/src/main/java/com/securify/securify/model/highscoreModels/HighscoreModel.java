package com.securify.securify.model.highscoreModels;

import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alwin on 06.05.2018.
 */


public class HighscoreModel {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private long userId;
    private long gameId;

    private boolean played;
    private long score;


    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
