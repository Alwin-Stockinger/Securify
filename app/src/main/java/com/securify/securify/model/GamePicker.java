package com.securify.securify.model;

import android.content.Context;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.daos.gameDaos.PasswordDao;
import com.securify.securify.database.daos.gameDaos.PermissionDao;
import com.securify.securify.database.daos.gameDaos.PhishingDao;
import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.gameModels.PermissionModel;
import com.securify.securify.model.gameModels.PhishingModel;

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

    PhishingModel getPhisGameById(long id){
        PhishingDao dao=db.phishingDao();
        PhishingModel game=dao.getById(id);
        return game;
    }
}
