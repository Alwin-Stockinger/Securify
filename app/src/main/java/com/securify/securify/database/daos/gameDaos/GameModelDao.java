package com.securify.securify.database.daos.gameDaos;

import android.arch.persistence.room.Dao;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.gameModels.GameModel;

/**
 * Created by Alwin on 27.04.2018.
 */

@Dao
public interface GameModelDao<T> extends BaseDao<T> {

    GameModel getById(long id);
}
