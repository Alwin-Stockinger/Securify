package com.securify.securify.model;

import android.content.Context;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.PasswordDao;
import com.securify.securify.database.PermissionDao;
import com.securify.securify.database.PhishingDao;
import com.securify.securify.database.PopulationFactory;
import com.securify.securify.gameModels.PasswordModel;
import com.securify.securify.gameModels.PermissionModel;
import com.securify.securify.gameModels.PhishingModel;

/**
 * Created by Alwin on 06.05.2018.
 */

public class MainModel {
    Context context;
    AppDatabase db;
    GamePicker gamePicker;

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
    }









    //test retrieve
    public PasswordModel getMaxPassGame(){
        PasswordDao dao=db.passwordDao();
        return dao.getMax();
    }







}