package com.securify.securify.model.userModels;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.securify.securify.model.gameModels.PermissionModel;

import java.util.List;

public class PermissionWithUsers {
    @Embedded
    PermissionModel permissionModel;

    @Relation(
            parentColumn = "id",
            entityColumn="gameId",
            entity = UserPermissionModel.class,
            projection = "userId"
    )
    List<Long> userIdList;
}
