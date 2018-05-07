package com.securify.securify.database.daos.otherDaos;

import android.arch.persistence.room.Query;

/**
 * Created by vitor on 04/05/18.
 */

public interface ScoreDao {
  @Query("SELECT SUM(q.value) FROM question q JOIN score s ON s.question_id = q.id")
  public float overall();
}
