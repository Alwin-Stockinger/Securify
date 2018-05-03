package com.securify.securify.gameModels;

// DB related imports
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;

import com.securify.securify.gameModels.Quiz;


/**
 * Created by vitor on 03/05/18.
 */

 @Entity(
   tableName="quiz"
  //  , indices = @Index(value = {"first_name", "last_name"}, unique = true)
   , foreignKeys = @ForeignKey(
     entity = Quiz.class,
     parentColumns = "id",
     childColumns = "game_id"
   )
 )
public class Quiz {

  @PrimaryKey(autoGenerate = true)
  public int id;

  @ColumnInfo(name = "name")
  public String name;

  @ColumnInfo(name = "game_id")
  public int game;

}
