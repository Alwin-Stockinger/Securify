package com.securify.securify.database.daos.otherDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.securify.securify.model.gameModels.GameModel;

import java.util.List;

/**
 * Created by Alwin on 27.04.2018.
 */

@Dao
public interface GameModelDao {

    @Insert
    public void insertGame(GameModel game);

    @Query("SELECT * FROM gameModel")
    public List<GameModel> getAllGames();

}
