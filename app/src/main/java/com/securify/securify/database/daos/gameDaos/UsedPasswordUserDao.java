package com.securify.securify.database.daos.gameDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.gameModels.UsedPasswordModel;
import com.securify.securify.model.gameModels.UsedPasswordUserModel;

import java.util.List;

@Dao
public abstract class UsedPasswordUserDao implements BaseDao<UsedPasswordUserModel> {

    @Query("SELECT usedPasswordUserJoin.* FROM usedPasswordUserJoin INNER JOIN usedPassword On usedPasswordUserJoin.passwordId=usedPassword.id WHERE (userId=:userId AND usedPassword.password=:password)")
    public abstract UsedPasswordUserModel getUsedPasswordUserModelByUserIdAndPassword(long userId, String password);

    @Query("SELECT usedPassword.* FROM usedPasswordUserJoin INNER JOIN usedPassword ON usedPasswordUserJoin.passwordId=usedPassword.id WHERE userId=:userId")
    public abstract List<UsedPasswordModel> getUsedPasswordModelByUserId(long userId);

    @Query("SELECT EXISTS(SELECT * FROM usedPasswordUserJoin INNER JOIN usedPassword ON usedPasswordUserJoin.passwordId=usedPassword.id WHERE (userId=:userId AND password=:password))")
    public abstract boolean isPasswordUsedByUserId(String password, long userId);
}
