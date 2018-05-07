package com.securify.securify.database.daos.gameDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.gameModels.PasswordModel;

import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */

@Dao
public abstract class PasswordDao implements BaseDao<PasswordModel> {

    @Query("SELECT * FROM passwortspiel")
    abstract public List<PasswordModel> getAllPasswordGames();

    @Query("SELECT * FROM passwortspiel WHERE id = :id")
    abstract public PasswordModel getById(long id);

    @Query("SELECT * FROM passwortspiel ORDER BY id DESC LIMIT 1")
    abstract public PasswordModel getMax();

    @Query("DELETE FROM passwortspiel WHERE id= :id")
    abstract public void deleteGame(long id);
}
