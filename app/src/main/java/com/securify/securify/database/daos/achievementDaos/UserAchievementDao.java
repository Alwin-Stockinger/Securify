package com.securify.securify.database.daos.achievementDaos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.securify.securify.database.daos.BaseDao;
import com.securify.securify.model.achievementModels.AchievementModel;
import com.securify.securify.model.achievementModels.UserAchievementModel;

import java.util.List;

/**
 * Created by Alwin on 11.05.2018.
 */

@Dao
public abstract class UserAchievementDao implements BaseDao<UserAchievementModel> {

    @Query("SELECT EXISTS(SELECT * FROM userAchievementJoin WHERE (userId=:userId AND achievementId=:achievementId))")
    abstract public boolean isAchieved(long userId, long achievementId);

    @Query("SELECT achievement.* FROM userAchievementJoin INNER JOIN achievement WHERE (userId=:userId AND language=:language)")
    abstract public List<AchievementModel> getAllAchievedWithLanguage(long userId, String language);
}
