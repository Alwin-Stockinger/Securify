package com.securify.securify.model.otherModels;

// DB related imports
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;

/**
 * Created by vitor on 30/04/18.
 */

@Entity(
  tableName="config"
  // , indices = @Index(value = {"first_name", "last_name"}, unique = true)
  , indices = @Index(value = "persona_id", unique = true)
  , foreignKeys = @ForeignKey(
    entity = Persona.class,
    parentColumns = "id",
    childColumns = "persona_id"
  )
)
public class Config {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "score")
    public double score;

    @ColumnInfo(name = "persona_id")
    public int persona;

}
