package com.securify.securify.model.gameModels;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import com.securify.securify.model.userModels.UserModel;

@Entity(tableName = "usedPasswordUserJoin",
        primaryKeys = {"userId","passwordId"},
        foreignKeys = {
                @ForeignKey(entity = UserModel.class,
                            parentColumns = "id",
                            childColumns = "userId"),
                @ForeignKey(entity = UsedPasswordModel.class,
                            parentColumns = "id",
                            childColumns = "passwordId")},
        indices = {@Index("userId"),@Index("passwordId")})
public class UsedPasswordUserModel {
    private long userId;
    private long passwordId;

    public UsedPasswordUserModel(long userId, long passwordId){
        this.userId=userId;
        this.passwordId=passwordId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(long passwordId) {
        this.passwordId = passwordId;
    }
}
