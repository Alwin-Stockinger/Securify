package com.securify.securify.database.daos.otherDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

/**
 * Created by vitor on 01/05/18.
 */

@Dao
public interface ConfigDao {
  @Query("SELECT SUM(q.value) FROM question q JOIN score s ON s.question_id = q.id WHERE s.user_id = :userId")
  public float getScore(int user_id);
}
