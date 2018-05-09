package com.securify.securify.model;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.daos.gameDaos.PasswordDao;
import com.securify.securify.database.daos.gameDaos.PermissionDao;
import com.securify.securify.database.daos.gameDaos.PhishingDao;
import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.gameModels.PermissionModel;
import com.securify.securify.model.gameModels.PhishingModel;
import com.securify.securify.model.userModels.UserModel;

/**
 * Created by Alwin on 06.05.2018.
 */

 class GamePicker {


    private AppDatabase db;
    private UserModel user;

    GamePicker(AppDatabase db,UserModel user){
        this.db=db;
        this.user=user;
    }

    PasswordModel getRandomPassGame(){
        return db.userPasswordDao().getRandomGame(user.getId());
    }
    PermissionModel getRandomPermGame(){
        return db.userPermissionDao().getRandomGame(user.getId());
    }
    PhishingModel getRandomPhishGame(){
        return db.userPhishingDao().getRandomGame(user.getId());
    }

    PasswordModel getPassGameById(long id){
        PasswordDao dao=db.passwordDao();
        return dao.getById(id);
    }

    PermissionModel getPermGameById(long id) {
        PermissionDao dao=db.permissionDao();
        return dao.getById(id);
    }

    PhishingModel getPhisGameById(long id){
        PhishingDao dao=db.phishingDao();
        return dao.getById(id);
    }
}
