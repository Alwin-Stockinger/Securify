package com.securify.securify.database.daos.userDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.userModels.UserPasswordModel;

import java.util.List;

/**
 * Created by Alwin on 07.05.2018.
 */

@Dao
public abstract class UserPasswordDao implements BaseDao<UserPasswordModel> {

    @Query("SELECT * FROM userPassword INNER JOIN passwortspiel ON gameId=passwortspiel.id WHERE userId=:uId")
    abstract public List<PasswordModel> getPasswordGamesByUserId(long uId);

}