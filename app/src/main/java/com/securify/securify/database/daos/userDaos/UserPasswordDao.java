package com.securify.securify.database.daos.userDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.userModels.UserPasswordModel;

import java.util.List;

/**
 * Created by Alwin on 07.05.2018.
 */

@Dao
public abstract class UserPasswordDao implements UserGameDao<UserPasswordModel,PasswordModel>{

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)     //Supresses Warning that complains about not all columns used, but this is wanted
    @Query("SELECT * FROM userPassword INNER JOIN passwortspiel ON gameId=passwortspiel.id WHERE userId=:uId")
    abstract public List<PasswordModel> getGamesByUserId(long uId);

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)     //Supresses Warning that complains about not all columns used, but this is wanted
    @Query("SELECT * FROM userPassword INNER JOIN passwortspiel ON gameId=passwortspiel.id WHERE (userId=:uId AND played=0 AND sprache=:language) ORDER BY RANDOM() LIMIT 1")
    abstract public PasswordModel getRandomNotPlayedGame(long uId, String language);

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)     //Supresses Warning that complains about not all columns used, but this is wanted
    @Query("SELECT * FROM userPassword INNER JOIN passwortspiel ON gameId=passwortspiel.id WHERE (userId=:uId AND sprache=:language) ORDER BY RANDOM() LIMIT 1")
    abstract public PasswordModel getRandomGame(long uId,String language);

    @Query("SELECT * FROM userPassword WHERE userId=:uId")
    abstract public List<UserPasswordModel> getUserGamesByUserId(long uId);

    @Query("SELECT * FROM userPassword WHERE (userId=:uId AND gameId=:pId)")
    abstract public UserPasswordModel getUserPassword(long uId, long pId);

}