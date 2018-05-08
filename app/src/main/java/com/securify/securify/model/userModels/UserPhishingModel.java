package com.securify.securify.model.userModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import com.securify.securify.model.gameModels.PhishingModel;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Alwin on 08.05.2018.
 */
@Entity(tableName = "userPhsishing",foreignKeys = {@ForeignKey(entity = UserModel.class,
                                                                parentColumns = "id",
                                                                childColumns = "userId",
                                                                onDelete = CASCADE),
                                                    @ForeignKey(entity = PhishingModel.class,
                                                                parentColumns = "id",
                                                                childColumns = "gameId",
                                                                onDelete=CASCADE)}
                                    , indices = {   @Index("userId"),
                                                    @Index("gameId")})
public class UserPhishingModel extends  UserGameModel{
    public UserPhishingModel(long userId,long gameId,boolean played){
        super(userId,gameId,played);
    }
}
