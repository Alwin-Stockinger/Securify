package com.securify.securify.model.highscoreModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Relation;

import com.securify.securify.model.gameModels.PermissionModel;

import java.util.List;

/**
 * Created by Alwin on 07.05.2018.
 */

@Entity(tableName = "permission_highscores")
public class HighscorePermissionModel extends HighscoreModel {
    @Relation(parentColumn = "game_id",entityColumn = "permission_id",entity = PermissionModel.class)
    private List<PermissionModel> games;

    public List<PermissionModel> getGames() {
        return games;
    }

    public void setGames(List<PermissionModel> games) {
        this.games = games;
    }

}
