package com.securify.securify.database.daos.userDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.userModels.UserModel;

import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */

@Dao
public abstract class UserDao implements BaseDao<UserModel> {
    @Query("SELECT * FROM user")
    abstract public List<UserModel> getAllUsers();

    @Query("SELECT * FROM user WHERE id = :id")
    abstract public UserModel getById(long id);

    @Query("SELECT * FROM user ORDER BY passwordHighscore desc limit :top ")
    abstract public List<UserModel> getTopPassword(int top);

    @Query("SELECT * FROM user ORDER BY phishingHighscore desc limit :top ")
    abstract public List<UserModel> getTopPhishing(int top);

    @Query("SELECT * FROM user ORDER BY permissionHighscore desc limit :top ")
    abstract public List<UserModel> getTopPermission(int top);

    @Query("SELECT EXISTS(SELECT * FROM user WHERE name=:name)")
    abstract public boolean doesUserExistWithName(String name);

    @Query("SELECT * FROM user WHERE name=:name")
    abstract public UserModel getByName(String name);

}
