package com.securify.securify.database;

/**
 * Created by vitor on 04/05/18.
 */

public interface ScoreDao {
  @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
  public User[] loadAllUsersBetweenAges(int minAge, int maxAge);
}
