package com.securify.securify.database.daos.userDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.gameModels.PhishingModel;
import com.securify.securify.model.userModels.UserPhishingModel;

import java.util.List;

/**
 * Created by Alwin on 08.05.2018.
 */

@Dao
public abstract class UserPhishingDao implements BaseDao<UserPhishingModel> {
    @Query("SELECT * FROM userPhsishing INNER JOIN phishingspiel ON gameId=phishingspiel.id WHERE userId=:uId")
    abstract public List<PhishingModel> getPhishingGamesByUserId(long uId);
}
