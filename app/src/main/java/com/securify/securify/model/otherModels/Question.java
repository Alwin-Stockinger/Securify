package com.securify.securify.model.otherModels;

// DB related imports
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;

import com.securify.securify.model.otherModels.Quiz;


/**
 * Created by vitor on 03/05/18.
 */

 @Entity(
   tableName="question"
   , indices = @Index(value = "quiz_id", unique = true)
   , foreignKeys = @ForeignKey(
     entity = Quiz.class,
     parentColumns = "id",
     childColumns = "quiz_id"
   )
)
public class Question {

  @PrimaryKey(autoGenerate = true)
  public int id;

  @ColumnInfo(name = "statement")
  public String body;

  @ColumnInfo(name = "value")
  public float value;

  @ColumnInfo(name = "quiz_id")
  public int quiz;

  @ColumnInfo(name = "answered")
  public boolean answered;

}
