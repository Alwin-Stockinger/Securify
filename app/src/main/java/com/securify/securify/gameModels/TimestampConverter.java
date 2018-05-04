package com.securify.securify.gameModels;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by vitor on 04/05/18.
 */

// http://androidkt.com/datetime-datatype-sqlite-using-room/
 public class TimestampConverter {
  static DateFormat df = new SimpleDateFormat(Constants.TIME_STAMP_FORMAT);

  @TypeConverter
  public static Date fromTimestamp(String value) {
     if (value != null) {
         try {
             return df.parse(value);
         } catch (ParseException e) {
             e.printStackTrace();
         }
         return null;
     } else {
         return null;
     }
  }
}
