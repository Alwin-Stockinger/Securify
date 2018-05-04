package com.securify.securify.gameModels;

// DB related imports
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by vitor on 30/04/18.
 */
@Entity(tableName = "persona")
public class Persona {

  @PrimaryKey(autoGenerate = true)
  public int id;

  @ColumnInfo(name = "code")
  public int code;

  @ColumnInfo(name = "name")
  public String name;

  @ColumnInfo(name = "age")
  public int age;

  @ColumnInfo(name = "profession")
  public String profession;

}
