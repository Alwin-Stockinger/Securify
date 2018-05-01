package com.securify.securify.gameModels;

// DB related imports
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;

import com.securify.securify.gameModels.Persona;

/**
 * Created by vitor on 30/04/18.
 */

@Entity(
  tableName="config"
  , indices = @Index(value = {"first_name", "last_name"}, unique = true)
  , foreignKeys = @ForeignKey(entity = Persona.class,
                                  parentColumns = "code",
                                  childColumns = "persona_id"))
public class Config {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "score")
    public double score;

    @Embedded
    @ColumnInfo(name = "persona_id")
    public Persona persona;
}
