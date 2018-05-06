package com.securify.securify.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.securify.securify.gameModels.PasswordModel;

import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */

@Dao
public interface PasswordDao extends GameModelDao {

    @Insert
    public void insertGame(PasswordModel password);

    @Query("SELECT * FROM passwortspiel")
    public List<PasswordModel> getAllPasswordGames();

    @Query("SELECT * FROM passwortspiel WHERE id = :id")
    public PasswordModel getById(long id);
}
