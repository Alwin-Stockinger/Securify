package com.securify.securify.database.daos.userDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.userModels.UserModel;
import com.securify.securify.model.userModels.UserPermissionModel;

import java.util.List;

@Dao
public abstract class UserPermissionDao implements BaseDao<UserPermissionModel>{
    @Query("SELECT * FROM userPermission")
    abstract public List<UserPermissionModel> getAllUserPermissions();

    @Query("SELECT * FROM userPermission WHERE id = :id")
    abstract public UserPermissionModel getById(long id);

    @Query("SELECT * FROM userPermission WHERE (userId=:uId AND gameId=:pId) ")
    abstract public UserPermissionModel getByUserAndPermission(long uId,long pId);

}
