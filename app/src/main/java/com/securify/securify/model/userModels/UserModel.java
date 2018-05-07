package com.securify.securify.model.userModels;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alwin on 06.05.2018.
 */

@Entity(tableName = "user",indices = {@Index(value = "name",unique=true)})
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;

    private long passwordHighscore;
    private long permissionHighscore;
    private long phishingHighscore;

    public long getPasswordHighscore() {
        return passwordHighscore;
    }

    public void setPasswordHighscore(long passwordHighscore) {
        this.passwordHighscore = passwordHighscore;
    }

    public long getPermissionHighscore() {
        return permissionHighscore;
    }

    public void setPermissionHighscore(long permissionHighscore) {
        this.permissionHighscore = permissionHighscore;
    }

    public long getPhishingHighscore() {
        return phishingHighscore;
    }

    public void setPhishingHighscore(long phishingHighscore) {
        this.phishingHighscore = phishingHighscore;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
