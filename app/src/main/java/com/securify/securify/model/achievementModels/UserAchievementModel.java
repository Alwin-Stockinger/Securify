package com.securify.securify.model.achievementModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import com.securify.securify.model.userModels.UserModel;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Alwin on 11.05.2018.
 */

@Entity(tableName = "userAchievementJoin",
        primaryKeys = {"userId","achievementId"},
        foreignKeys = { @ForeignKey(entity = UserModel.class,
                                    parentColumns = "id",
                                    childColumns = "userId",
                                    onDelete = CASCADE),
                        @ForeignKey(entity = AchievementModel.class,
                                    parentColumns = "id",
                                    childColumns = "achievementId",
                                    onDelete=CASCADE)},
        indices = {     @Index("userId"),
                        @Index("achievementId")})
public class UserAchievementModel {
    private long userId;
    private long achievementId;

    private Date date;

    public UserAchievementModel(long userId,long achievementId, Date date){
        this.userId=userId;
        this.achievementId=achievementId;
        this.date=date;
    }

    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(long achievementId) {
        this.achievementId = achievementId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
