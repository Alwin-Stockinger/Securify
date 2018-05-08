package com.securify.securify.model.userModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import com.securify.securify.model.gameModels.PermissionModel;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "userPermission",foreignKeys = {@ForeignKey(entity = UserModel.class,
                                                                parentColumns = "id",
                                                                childColumns = "userId",
                                                                onDelete = CASCADE),
                                                    @ForeignKey(entity = PermissionModel.class,
                                                                parentColumns = "id",
                                                                childColumns = "gameId",
                                                                onDelete=CASCADE)})
public class UserPermissionModel extends UserGameModel {

    public UserPermissionModel(long userId,long gameId,boolean played){
        super(userId,gameId,played);
    }
}
