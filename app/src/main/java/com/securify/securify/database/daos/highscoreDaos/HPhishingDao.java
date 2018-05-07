package com.securify.securify.database.daos.highscoreDaos;

import android.arch.persistence.room.Dao;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.highscoreModels.HighscorePhishingModel;

/**
 * Created by Alwin on 07.05.2018.
 */

@Dao
public abstract class HPhishingDao implements BaseDao<HighscorePhishingModel> {
}
