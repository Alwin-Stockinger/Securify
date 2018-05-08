package com.securify.securify.model.gameModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/*
This Table contains the used passwords
 */
@Entity(tableName = "usedPassword",indices = @Index(value = "password",unique = true))
public class UsedPasswordModel {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String password;

    public UsedPasswordModel(String password){
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
