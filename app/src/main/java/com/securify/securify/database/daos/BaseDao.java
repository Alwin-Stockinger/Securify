package com.securify.securify.database.daos;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Alwin on 07.05.2018.
 */

public interface BaseDao<T> {

    @Insert
    void insert(T obj);

    @Insert
    void insertAll(List<T> obj);

    @Insert
    long insertGetLong(T obj);

    @Update
    void update(T obj);

}
