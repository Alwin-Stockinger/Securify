package com.securify.securify.gameModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alwin on 27.04.2018.
 */

@Entity
public class GameModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
}
