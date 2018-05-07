package com.securify.securify.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.model.UserModel;

import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */

@Dao
public abstract class UserDao implements BaseDao<UserModel>{
    @Query("SELECT * FROM user")
    abstract public List<UserModel> getAllUsers();

    @Query("SELECT * FROM user WHERE id = :id")
    abstract public UserModel getById(long id);
}
