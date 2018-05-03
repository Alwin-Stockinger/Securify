package com.securify.securify.gameModels;

// DB related imports
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;

import com.securify.securify.gameModels.Quiz;
import com.securify.securify.gameModels.Config;
import com.securify.securify.gameModels.Question;

/**
 * Created by vitor on 03/05/18.
 */

@Entity(
  tableName="score"
  , indices = @Index(value = {"user_id", "question_id"}, unique = true)
  , foreignKeys = {
    @ForeignKey(
      entity = Config.class,
      parentColumns = "id",
      childColumns = "user_id"
    )
    , @ForeignKey(
      entity = Question.class,
      parentColumns = "id",
      childColumns = "question_id"
    )
   }
)
public class Score {

  @PrimaryKey(autoGenerate = true)
  public int id;

  @ColumnInfo(name = "user_id")
  public String user;

  @ColumnInfo(name = "question_id")
  public int question;

}
