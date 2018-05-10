package com.securify.securify.model.userModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
abstract public class UserGameModel {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private long userId;
    private long gameId;

    private boolean played;
    private boolean succeeded;

    UserGameModel(long userId,long gameId, boolean played, boolean succeeded){
        this.userId=userId;
        this.gameId=gameId;
        this.played=played;
        this.succeeded=succeeded;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
