package com.securify.securify.model;

import android.content.Context;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.PopulationFactory;
import com.securify.securify.database.daos.gameDaos.PasswordDao;
import com.securify.securify.database.daos.gameDaos.PermissionDao;
import com.securify.securify.database.daos.gameDaos.PhishingDao;
import com.securify.securify.database.daos.userDaos.UserDao;
import com.securify.securify.database.daos.userDaos.UserPasswordDao;
import com.securify.securify.database.daos.userDaos.UserPermissionDao;
import com.securify.securify.database.daos.userDaos.UserPhishingDao;
import com.securify.securify.model.achievementModels.AchievementModel;
import com.securify.securify.model.achievementModels.UserAchievementModel;
import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.gameModels.PermissionModel;
import com.securify.securify.model.gameModels.PhishingModel;
import com.securify.securify.model.gameModels.UsedPasswordModel;
import com.securify.securify.model.gameModels.UsedPasswordUserModel;
import com.securify.securify.model.userModels.UserGameModel;
import com.securify.securify.model.userModels.UserModel;
import com.securify.securify.model.userModels.UserPasswordModel;
import com.securify.securify.model.userModels.UserPermissionModel;
import com.securify.securify.model.userModels.UserPhishingModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */

public class MainModel {
    private AppDatabase db;
    private GamePicker gamePicker;

    private UserModel activeUser;

    public UserModel getActiveUser() {
        return activeUser;
    }

    private void setActiveUser(UserModel activeUser) {
        this.activeUser = activeUser;
    }


    public MainModel(Context context){
        this.db=AppDatabase.getDatabase(context);
        this.gamePicker=new GamePicker(db,getActiveUser());

        setActiveUser(db.userDao().getActiveUser());
    }

    public PasswordModel getRandomPasswordGame(){
        return gamePicker.getRandomPassGame();
    }

    public PhishingModel getRandomPhishingGame(){
        return gamePicker.getRandomPhishGame();
    }

    public PermissionModel getRandomPermissionGame(){
        return gamePicker.getRandomPermGame();
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

        db.achievementDao().insertAll(factory.getAchievementModels());

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
            userPhishingModels.addAll(initUserWithPhishing(user,phishingModels));
        }

        db.userPermissionDao().insertAll(userPermissionModels);
        db.userPasswordDao().insertAll(userPasswordModels);
        db.userPhishingDao().insertAll(userPhishingModels);
    }

    private List<UserPermissionModel> initUserWithPermissions(UserModel user, List<PermissionModel> permissionModels){

        List<UserPermissionModel> insertList=new ArrayList<>();

        for(PermissionModel permissionModel:permissionModels){
            UserPermissionModel userPermissionModel=new UserPermissionModel(user.getId(),permissionModel.getId(),false,false);

            insertList.add(userPermissionModel);
        }

        return insertList;
    }


    private List<UserPhishingModel> initUserWithPhishing(UserModel user,List<PhishingModel> phishingModels){

        List<UserPhishingModel> insertList=new ArrayList<>();

        for(PhishingModel phishingModel:phishingModels){
            UserPhishingModel userPhishingModel=new UserPhishingModel(user.getId(),phishingModel.getId(),false, false);

            insertList.add(userPhishingModel);
        }
        return insertList;
    }


    private List<UserPasswordModel> initUserWithPasswords(UserModel user,List<PasswordModel> passwordModels){

        List<UserPasswordModel> inserList=new ArrayList<>();

        for(PasswordModel passwordModel:passwordModels){
            UserPasswordModel userPasswordModel=new UserPasswordModel(user.getId(),passwordModel.getId(),false,false);

            inserList.add(userPasswordModel);
        }
        return inserList;
    }

    //Password Used Methods, This Methods are for checking if password was already used and inserting used passwords
    public boolean isPasswordUsed(String password){
        return db.usedPasswordUserDao().isPasswordUsedByUserId(password,activeUser.getId());
    }

    public void setPasswordUsed(String password){
        long passwordId;
        if(db.usedPasswordDao().doesExist(password)){
            passwordId=db.usedPasswordDao().getUsedPasswordByPassword(password).getId();
        }
        else{
            UsedPasswordModel usedPasswordModel=new UsedPasswordModel(password);
            passwordId=db.usedPasswordDao().insertGetLong(usedPasswordModel);
        }
        UsedPasswordUserModel usedPasswordUserModel=new UsedPasswordUserModel(activeUser.getId(),passwordId);
        db.usedPasswordUserDao().insert(usedPasswordUserModel);
    }

    //User Methods---------------------------------
    public UserModel changeUser(String name){
        UserDao userDao=db.userDao();
        activeUser.setActive(false);
        userDao.update(activeUser);

        if(userDao.doesUserExistWithName(name)){
            setActiveUser(userDao.getByName(name));
        }
        else{   //creates new User
            UserModel user=new UserModel(name);
            user.setLanguage(activeUser.getLanguage());       //sets language for new User to the language of the previous user
            user.setId(userDao.insertGetLong(user));        //inserts User and changes Id to correct autoincremented Id

            db.userPhishingDao().insertAll(initUserWithPhishing(user,db.phishingDao().getAllPhishingGames()));
            db.userPermissionDao().insertAll(initUserWithPermissions(user,db.permissionDao().getAllPermissionGames()));
            db.userPasswordDao().insertAll(initUserWithPasswords(user,db.passwordDao().getAllPasswordGames()));

            setActiveUser(user);
        }
        activeUser.setActive(true);
        userDao.update(activeUser);
        return activeUser;
    }

    public void changeLanguage(String language){
        activeUser.setLanguage(language);
        db.userDao().update(activeUser);
    }





    //return progress percentage of game-----------------------------------
    private<T extends UserGameModel> int getGameProgress(List<T> list){

        int gamesCount=list.size();
        int gamesPlayed=0;
        for(T t:list){
            if(t.isPlayed()){
                gamesPlayed++;
            }
        }
        if(gamesCount==0) return 100;
        else return 100*gamesPlayed/gamesCount;
    }

    public int getPermissionProgress(){
        List<UserPermissionModel> userPermissionModels=db.userPermissionDao().getUserGamesByUserId(activeUser.getId());
        return getGameProgress(userPermissionModels);
    }
    public int getPassswordProgress(){
        List<UserPasswordModel> userPasswordModels=db.userPasswordDao().getUserGamesByUserId(activeUser.getId());
        return getGameProgress(userPasswordModels);
    }
    public int getPhishingProgress(){
        List<UserPhishingModel> userPhishingModels=db.userPhishingDao().getUserGamesByUserId(activeUser.getId());
        return getGameProgress(userPhishingModels);
    }


    //HIGHSCORE METHODS-------------------
    //methods to set user Highscores that also check if it is a new highscore, if it is not a new highscore nothing happens
    public void setUserPasswordHighscore(long highscore){
        UserModel user=getActiveUser();
        if(user.getPasswordHighscore()<highscore){
            user.setPasswordHighscore(highscore);
            db.userDao().update(user);
        }
    }
    public void setUserPhishingHighscore(long highscore){
        UserModel user=getActiveUser();
        if(user.getPhishingHighscore()<highscore){
            user.setPhishingHighscore(highscore);
            db.userDao().update(user);
        }
    }
    public void setUserPermissionHighscore(long highscore){
        UserModel user=getActiveUser();
        if(user.getPermissionHighscore()<highscore){
            user.setPermissionHighscore(highscore);
            db.userDao().update(user);
        }
    }


    //Methods for the Highscores, they com already ordered from the database
    public List<UserModel> getTopPassword(int top_count){
        return db.userDao().getTopPassword(top_count);
    }
    public List<UserModel> getTopPhishing(int top_count){
        return db.userDao().getTopPhishing(top_count);
    }
    public List<UserModel> getTopPermission(int top_count){
        return db.userDao().getTopPermission(top_count);
    }

    //Played and succeeded Game setting
    public void setPasswordSucceeded(PasswordModel password, boolean succeeded){
        UserPasswordDao dao=db.userPasswordDao();
        UserPasswordModel userPassword=dao.getUserPassword(activeUser.getId(),password.getId());
        userPassword.setPlayed(true);

        if(succeeded) userPassword.setSucceeded(true);

        dao.update(userPassword);
    }
    public void setPhishingSucceeded(PhishingModel phishing, boolean succeeded){
        UserPhishingDao dao=db.userPhishingDao();
        UserPhishingModel userPhishing=dao.getUserPhishing(activeUser.getId(),phishing.getId());
        userPhishing.setPlayed(true);

        if(succeeded) userPhishing.setSucceeded(true);

        dao.update(userPhishing);
    }
    public void setPermissionSucceded(PermissionModel permission, boolean succeeded){
        UserPermissionDao dao=db.userPermissionDao();
        UserPermissionModel userPermission=dao.getUserPermission(activeUser.getId(),permission.getId());
        userPermission.setPlayed(true);

        if(succeeded) userPermission.setSucceeded(true);

        dao.update(userPermission);
    }

    //achievement Mehtods

    //Creates new succeeded achievement entry, the method will do nothing if already succeeded
    public void achievementSuccess(long achievementId){
        if(!db.userAchievementDao().isAchieved(activeUser.getId(),achievementId)){
            UserAchievementModel userAchievementModel=new UserAchievementModel(activeUser.getId(),achievementId,new Date());
            db.userAchievementDao().insert(userAchievementModel);
        }
    }

    public  List<AchievementModel> getAchievedAchievements(){
        return db.userAchievementDao().getAllAchievedWithLanguage(activeUser.getId(),activeUser.getLanguage());
    }

    public List<AchievementModel> getAllAchievements(){
        return db.achievementDao().getAllAchievementsWithLanguage(activeUser.getLanguage());
    }




    //NOT RELEVANT METHODS---------------------------
    public PasswordModel getMaxPassGame(){
        PasswordDao dao=db.passwordDao();
        return dao.getMax();
    }



}
