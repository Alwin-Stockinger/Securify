package com.securify.securify.gameModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Alwin on 06.05.2018.
 */

@Entity(tableName = "user")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    long id;

    String name;
    Date lastLogin;

}
