package com.securify.securify.database.daos.gameDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.gameModels.PhishingModel;

import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */

@Dao
public abstract class PhishingDao implements BaseDao<PhishingModel>{


    @Query("SELECT * FROM phishingspiel")
    abstract public List<PhishingModel> getAllPhishingGames();

    @Query("SELECT * FROM phishingspiel WHERE id = :id")
    abstract public PhishingModel getById(long id);

    @Query("SELECT * FROM phishingspiel ORDER BY id DESC LIMIT 1")
    abstract public PhishingModel getMax();

    @Query("DELETE FROM phishingspiel WHERE id= :id")
    abstract public void deleteGame(long id);
}
