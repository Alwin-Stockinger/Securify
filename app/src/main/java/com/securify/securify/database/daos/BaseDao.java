package com.securify.securify.database.daos;

import android.arch.persistence.room.Insert;

import java.util.List;

/**
 * Created by Alwin on 07.05.2018.
 */

public interface BaseDao<T> {

    @Insert
    public void insert(T obj);

    @Insert
    public void insertAll(List<T> obj);

    @Insert
    public long insertGetLong(T obj);

}
