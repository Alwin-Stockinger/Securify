package com.securify.securify.model.highscoreModels;

import android.arch.persistence.room.Relation;

import java.util.List;

/**
 * Created by Alwin on 07.05.2018.
 */

public class HighscoreOfUsers {
    @Relation(
            parentColumn = "id",
            entityColumn = "userId",
            entity = HighscoreModel.class,
            projection = "gameId"
    )
    List<Long> gameIdList;
}
