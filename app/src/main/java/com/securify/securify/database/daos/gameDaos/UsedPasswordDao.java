package com.securify.securify.database.daos.gameDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.gameModels.UsedPasswordModel;

@Dao
public abstract class UsedPasswordDao implements BaseDao<UsedPasswordModel> {

    @Query("SELECT EXISTS(SELECT * FROM usedPassword WHERE password=:password)")
    abstract public boolean doesExist(String password);

    @Query("SELECT * FROM usedPassword WHERE password=:password")
    abstract public UsedPasswordModel getUsedPasswordByPassword(String password);
}
