package com.securify.securify.model;

import android.content.Context;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.daos.gameDaos.PasswordDao;
import com.securify.securify.database.daos.gameDaos.PermissionDao;
import com.securify.securify.database.daos.gameDaos.PhishingDao;
import com.securify.securify.database.PopulationFactory;
import com.securify.securify.database.daos.userDaos.UserDao;
import com.securify.securify.database.daos.userDaos.UserPermissionDao;
import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.gameModels.PermissionModel;
import com.securify.securify.model.gameModels.PhishingModel;
import com.securify.securify.model.userModels.UserModel;
import com.securify.securify.model.userModels.UserPermissionModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */

public class MainModel {
    private Context context;
    private AppDatabase db;
    private GamePicker gamePicker;

    public MainModel(Context context){
        this.context=context;

        db=AppDatabase.getDatabase(context);
        gamePicker=new GamePicker(context,db);
    }

    public PasswordModel getPassGameById(long id){
        return gamePicker.getPassGameById(id);
    }

    public PermissionModel getPermGameById(long id){
        return gamePicker.getPermGameById(id);
    }

    public PhishingModel getPhishGameById(long id){
        return gamePicker.getPhisGameById(id);
    }

    public void databaseinit(){
        PopulationFactory factory=new PopulationFactory();

        PasswordDao pDao=db.passwordDao();
        pDao.insertAll(factory.getPasswordModels());

        PhishingDao phDao=db.phishingDao();
        phDao.insertAll(factory.getPhishingModels());

        PermissionDao peDao=db.permissionDao();
        peDao.insertAll(factory.getPermissionModels());

        UserDao userDao=db.userDao();
        userDao.insertAll(factory.getUserModels());

        initUserPermission(userDao,peDao);
    }

    private void initUserPermission(UserDao userDao,PermissionDao permissionDao){
        List<UserModel> users=userDao.getAllUsers();
        List<PermissionModel> permissions=permissionDao.getAllPermissionGames();

        UserPermissionDao upDao=db.userPermissionDao();

        for(UserModel user :users){
            for(PermissionModel permission:permissions){
                UserPermissionModel userPermissionModel=new UserPermissionModel();

                userPermissionModel.setGameId(permission.getId());
                userPermissionModel.setUserId(user.getId());
                userPermissionModel.setPlayed(false);
            }
        }
    }



    public PasswordModel getMaxPassGame(){
        PasswordDao dao=db.passwordDao();
        return dao.getMax();
    }







}
