package com.securify.securify.database.daos.achievementDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.achievementModels.AchievementModel;

import java.util.List;

/**
 * Created by Alwin on 11.05.2018.
 */

@Dao
public abstract class AchievementDao implements BaseDao<AchievementModel> {

    @Query("SELECT * FROM achievement WHERE language=:language")
    public abstract List<AchievementModel> getAllAchievementsWithLanguage(String language);

}

