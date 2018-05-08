package com.securify.securify.database.daos.userDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import com.securify.securify.model.gameModels.PhishingModel;
import com.securify.securify.model.userModels.UserPhishingModel;

import java.util.List;

/**
 * Created by Alwin on 08.05.2018.
 */

@Dao
public abstract class UserPhishingDao implements UserGameDao<UserPhishingModel,PhishingModel> {
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)     //Supresses Warning that complains about not all columns used, but this is wanted
    @Query("SELECT * FROM userPhsishing INNER JOIN phishingspiel ON gameId=phishingspiel.id WHERE userId=:uId")
    abstract public List<PhishingModel> getPhishingGamesByUserId(long uId);

    @Query("SELECT * FROM userPhsishing WHERE userId=:uId")
    abstract public List<UserPhishingModel> getUserGamesByUserId(long uId);

}
