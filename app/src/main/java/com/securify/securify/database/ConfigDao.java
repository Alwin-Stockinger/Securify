package com.securify.securify.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.securify.securify.gameModels.Config;

import java.util.List;

/**
 * Created by vitor on 01/05/18.
 */

@Dao
public interface ConfigDao {
  @Query("SELECT * FROM score WHERE user_id =  :user_id")
  public float getScore(int user_id);
}
