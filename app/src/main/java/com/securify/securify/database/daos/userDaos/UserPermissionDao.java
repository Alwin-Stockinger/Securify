package com.securify.securify.database.daos.userDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

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

    @Query("SELECT permissionspiel.* FROM userPermission INNER JOIN permissionspiel ON gameId=permissionspiel.id WHERE userId=:uId")
    abstract public List<PermissionModel> getPermissionGamesByUserId(long uId);

    @Query("SELECT permissionspiel.* FROM userPermission INNER JOIN permissionspiel ON gameId=permissionspiel.id WHERE (userId=:uId AND played=0 AND sprache=:language) ORDER BY RANDOM() LIMIT 1")
    abstract public PermissionModel getRandomNotPlayedGame(long uId, String language);

    @Query("SELECT permissionspiel.* FROM userPermission INNER JOIN permissionspiel ON gameId=permissionspiel.id WHERE (userId=:uId AND sprache=:language) ORDER BY RANDOM() LIMIT 1")
    abstract public PermissionModel getRandomGame(long uId, String language);

    @Query("SELECT * FROM userPermission WHERE (userId=:uId AND gameId=:pId)")
    abstract public UserPermissionModel getUserPermission(long uId, long pId);

}
