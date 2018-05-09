package com.securify.securify.database.daos.gameDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.model.gameModels.PermissionModel;

import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */


@Dao
abstract public class PermissionDao implements GameModelDao<PermissionModel> {

    @Query("SELECT * FROM permissionspiel")
    abstract public List<PermissionModel> getAllPermissionGames();

    @Query("SELECT * FROM permissionspiel WHERE id = :id")
    abstract public PermissionModel getById(long id);

    @Query("SELECT * FROM permissionspiel ORDER BY id DESC LIMIT 1")
    abstract public PermissionModel getMax();

    @Query("DELETE FROM permissionspiel WHERE id= :id")
    abstract public void deleteGame(long id);
}