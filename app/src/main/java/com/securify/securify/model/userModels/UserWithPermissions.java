package com.securify.securify.model.userModels;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class UserWithPermissions {
    @Embedded
    UserModel user;

    @Relation(
            parentColumn = "id",
            entityColumn="userId",
            entity = UserPermissionModel.class,
            projection = "gameId"
    )
    List<Long> permissionIdList;

}
