package com.securify.securify.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.securify.securify.gameModels.PermissionModel;

import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */


@Dao
public interface PermissionDao extends GameModelDao {

    @Insert
    public void insertGame(PermissionModel model);

    @Insert
    public void insertAll(List<PermissionModel> permissionModels);

    @Query("SELECT * FROM permissionspiel")
    public List<PermissionModel> getAllPermissionGames();

    @Query("SELECT * FROM permissionspiel WHERE id = :id")
    public PermissionModel getById(long id);

    @Query("SELECT * FROM permissionspiel ORDER BY id DESC LIMIT 1")
    public PermissionModel getMax();

    @Query("DELETE FROM permissionspiel WHERE id= :id")
    public void deleteGame(long id);
}