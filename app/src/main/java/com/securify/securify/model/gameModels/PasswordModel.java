package com.securify.securify.model.gameModels;

import android.arch.persistence.room.Entity;

/**
 * Created by Alwin on 05.05.2018.
 */

@Entity(tableName = "passwortspiel")
public class PasswordModel extends  GameModel {

    private String verbotene_chars;
    private int min_length;
    private int max_length;
    private int min_upper;
    private int min_number;

    public String getVerbotene_chars() {
        return verbotene_chars;
    }

    public int getMin_length() {
        return min_length;
    }

    public void setMin_length(int min_length) {
        this.min_length = min_length;
    }

    public void setVerbotene_chars(String verbotene_chars) {
        this.verbotene_chars = verbotene_chars;
    }

    public int getMax_length() {
        return max_length;
    }

    public void setMax_length(int max_length) {
        this.max_length = max_length;
    }

    public int getMin_upper() {
        return min_upper;
    }

    public void setMin_upper(int min_upper) {
        this.min_upper = min_upper;
    }

    public int getMin_number() {
        return min_number;
    }

    public void setMin_number(int min_number) {
        this.min_number = min_number;
    }
}
