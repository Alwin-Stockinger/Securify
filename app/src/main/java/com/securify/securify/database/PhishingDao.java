package com.securify.securify.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.securify.securify.gameModels.PhishingModel;

import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */

@Dao
public interface PhishingDao {

    @Insert
    public void insertGame(PhishingModel model);

    @Query("SELECT * FROM phishingspiel")
    public List<PhishingModel> getAllPhishingGames();

    @Query("SELECT * FROM phishingspiel WHERE id = :id")
    public PhishingModel getById(long id);

    @Query("SELECT * FROM phishingspiel ORDER BY id DESC LIMIT 1")
    public PhishingModel getMax();

    @Query("DELETE FROM phishingspiel WHERE id= :id")
    public void deleteGame(long id);
}
