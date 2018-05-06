package com.securify.securify.model;

import android.content.Context;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.PasswordDao;
import com.securify.securify.database.PermissionDao;
import com.securify.securify.gameModels.PasswordModel;
import com.securify.securify.gameModels.PermissionModel;

/**
 * Created by Alwin on 06.05.2018.
 */

public class GamePicker {

    Context context;
    AppDatabase db;

    GamePicker(Context context,AppDatabase db){
        this.context=context;
        this.db=db;
    }

    PasswordModel getPassGameById(long id){
        PasswordDao dao=db.passwordDao();
        PasswordModel game=dao.getById(id);
        return game;
    }

    PermissionModel getPermGameById(long id) {
        PermissionDao dao=db.permissionDao();
        PermissionModel game=dao.getById(id);
        return game;
    }
}
