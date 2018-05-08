package com.securify.securify.database.daos.userDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import com.securify.securify.model.gameModels.PermissionModel;
import com.securify.securify.model.userModels.UserPermissionModel;

import java.util.List;

@Dao
public abstract class UserPermissionDao implements UserGameDao<UserPermissionModel,PermissionModel>{
    @Query("SELECT * FROM userPermission")
    abstract public List<UserPermissionModel> getAllUserPermissions();

    @Query("SELECT * FROM userPermission WHERE id = :id")
    abstract public UserPermissionModel getById(long id);

    @Query("SELECT * FROM userPermission WHERE (userId=:uId AND gameId=:pId) ")
    abstract public UserPermissionModel getByUserAndPermission(long uId,long pId);

    @Query("SELECT * FROM userPermission WHERE userId=:uId")
    abstract public List<UserPermissionModel> getUserGamesByUserId(long uId);

    @Query("SELECT * FROM userPermission INNER JOIN permissionspiel ON gameId=permissionspiel.id WHERE userId=:uId")
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)     //Supresses Warning that complains about not all columns used, but this is wanted
    abstract public List<PermissionModel> getPermissionGamesByUserId(long uId);

}
