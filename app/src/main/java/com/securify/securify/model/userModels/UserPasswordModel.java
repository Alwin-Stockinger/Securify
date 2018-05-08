package com.securify.securify.model.userModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import com.securify.securify.model.gameModels.PasswordModel;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Alwin on 07.05.2018.
 */

@Entity(tableName = "userPassword",foreignKeys = {@ForeignKey(entity = UserModel.class,
                                                                parentColumns = "id",
                                                                childColumns = "userId",
                                                                onDelete = CASCADE),
                                                    @ForeignKey(entity = PasswordModel.class,
                                                                parentColumns = "id",
                                                                childColumns = "gameId",
                                                                onDelete=CASCADE)}
                                    , indices = {   @Index("userId"),
                                                    @Index("gameId")})
public class UserPasswordModel extends UserGameModel {

    public UserPasswordModel(long userId,long gameId,boolean played){
        super(userId,gameId,played);
    }

}
