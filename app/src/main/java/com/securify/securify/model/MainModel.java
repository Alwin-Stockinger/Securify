package com.securify.securify.model;

import android.content.Context;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.PopulationFactory;
import com.securify.securify.database.daos.gameDaos.PasswordDao;
import com.securify.securify.database.daos.gameDaos.PermissionDao;
import com.securify.securify.database.daos.gameDaos.PhishingDao;
import com.securify.securify.database.daos.userDaos.UserDao;
import com.securify.securify.database.daos.userDaos.UserPermissionDao;
import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.gameModels.PermissionModel;
import com.securify.securify.model.gameModels.PhishingModel;
import com.securify.securify.model.userModels.UserModel;
import com.securify.securify.model.userModels.UserPasswordModel;
import com.securify.securify.model.userModels.UserPermissionModel;
import com.securify.securify.model.userModels.UserPhishingModel;

import java.util.ArrayList;
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

        PasswordDao paDao=db.passwordDao();
        paDao.insertAll(factory.getPasswordModels());

        PhishingDao phDao=db.phishingDao();
        phDao.insertAll(factory.getPhishingModels());

        PermissionDao peDao=db.permissionDao();
        peDao.insertAll(factory.getPermissionModels());

        UserDao userDao=db.userDao();
        userDao.insertAll(factory.getUserModels());

        initUserGameTables(userDao,peDao,phDao,paDao);

    }

    private void initUserGameTables(UserDao userDao,PermissionDao permissionDao,PhishingDao phishingDao, PasswordDao passwordDao){
        List<UserModel> users=userDao.getAllUsers();

        List<PermissionModel> permissionModels=permissionDao.getAllPermissionGames();
        List<PasswordModel> passwordModels=passwordDao.getAllPasswordGames();
        List<PhishingModel> phishingModels=phishingDao.getAllPhishingGames();

        List<UserPermissionModel> userPermissionModels=new ArrayList<>();
        List<UserPasswordModel> userPasswordModels=new ArrayList<>();
        List<UserPhishingModel> userPhishingModels=new ArrayList<>();

        for(UserModel user:users){
            userPermissionModels.addAll(initUserWithPermissions(user,permissionModels));
            userPasswordModels.addAll(initUserWithPasswords(user,passwordModels));
            userPhishingModels.addAll(initUserPhishing(user,phishingModels));
        }

        db.userPermissionDao().insertAll(userPermissionModels);
        db.userPasswordDao().insertAll(userPasswordModels);
        db.userPhishingDao().insertAll(userPhishingModels);
    }



    private List<UserPermissionModel> initUserWithPermissions(UserModel user, List<PermissionModel> permissionModels){

        List<UserPermissionModel> insertList=new ArrayList<>();

        for(PermissionModel permissionModel:permissionModels){
            UserPermissionModel userPermissionModel=new UserPermissionModel(user.getId(),permissionModel.getId(),false);

            insertList.add(userPermissionModel);
        }

        return insertList;
    }


    private List<UserPhishingModel> initUserPhishing(UserModel user,List<PhishingModel> phishingModels){

        List<UserPhishingModel> insertList=new ArrayList<>();

        for(PhishingModel phishingModel:phishingModels){
            UserPhishingModel userPhishingModel=new UserPhishingModel(user.getId(),phishingModel.getId(),false);

            insertList.add(userPhishingModel);
        }
        return insertList;
    }


    private List<UserPasswordModel> initUserWithPasswords(UserModel user,List<PasswordModel> passwordModels){

        List<UserPasswordModel> inserList=new ArrayList<>();

        for(PasswordModel passwordModel:passwordModels){
            UserPasswordModel userPasswordModel=new UserPasswordModel(user.getId(),passwordModel.getId(),false);

            inserList.add(userPasswordModel);
        }
        return inserList;
    }


    /*
    private <UserGame,Game> List<UserGame> initUserWithGames(UserModel user, List<Game> games,UserGame tempUserGame){
        List<UserGame> insertList=new ArrayList<>();

        Class<UserGame> userGameClass;

        try{
            UserGame userGame = userGameClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        for(Game game:games){
            UserGame userGame= UserGame;

        }
    }*/








    //return progress percentage in permission games
    public int getPermProgress(long userId){
        UserPermissionDao permDao=db.userPermissionDao();
        List<UserPermissionModel> list=permDao.getUserPermissionGamesByUserId(userId);

        int gamesCount=0;
        int gamesPlayed=0;
        for(UserPermissionModel userPermission:list){
            gamesCount++;
            if(userPermission.isPlayed()){
                gamesPlayed++;
            }
        }
        if(gamesCount==0) return 100;
        else return 100*gamesPlayed/gamesCount;
    }




    public PasswordModel getMaxPassGame(){
        PasswordDao dao=db.passwordDao();
        return dao.getMax();
    }


}
