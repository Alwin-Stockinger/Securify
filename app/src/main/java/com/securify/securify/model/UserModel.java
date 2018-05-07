package com.securify.securify.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alwin on 06.05.2018.
 */

@Entity(tableName = "user")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;

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
