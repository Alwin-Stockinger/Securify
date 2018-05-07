package com.securify.securify.model.highscoreModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Relation;

import com.securify.securify.model.gameModels.PhishingModel;

import java.util.List;

/**
 * Created by Alwin on 07.05.2018.
 */

@Entity(tableName = "phishing_highscores")
public class HighscorePhishingModel extends HighscoreModel {

    @Relation(parentColumn = "game_id",entityColumn = "phishing_id",entity = PhishingModel.class)
    private List<PhishingModel> games;

    public List<PhishingModel> getGames() {
        return games;
    }

    public void setGames(List<PhishingModel> games) {
        this.games = games;
    }

}
