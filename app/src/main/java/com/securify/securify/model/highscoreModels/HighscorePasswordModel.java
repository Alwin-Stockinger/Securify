package com.securify.securify.model.highscoreModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Relation;

import com.securify.securify.model.gameModels.PasswordModel;

import java.util.List;

/**
 * Created by Alwin on 07.05.2018.
 */

@Entity(tableName = "password_highscores")
public class HighscorePasswordModel extends HighscoreModel{


    @Relation(parentColumn = "game_id",entityColumn = "id",entity = PasswordModel.class)
    private List<PasswordModel> games;

    public List<PasswordModel> getGames() {
        return games;
    }

    public void setGames(List<PasswordModel> games) {
        this.games = games;
    }

}
