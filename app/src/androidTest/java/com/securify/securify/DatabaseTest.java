package com.securify.securify;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.daos.achievementDaos.AchievementDao;
import com.securify.securify.database.daos.achievementDaos.UserAchievementDao;
import com.securify.securify.database.daos.gameDaos.PasswordDao;
import com.securify.securify.database.daos.userDaos.UserDao;
import com.securify.securify.model.achievementModels.AchievementModel;
import com.securify.securify.model.achievementModels.UserAchievementModel;
import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.userModels.UserModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private AchievementDao achievementDao;
    private UserAchievementDao userAchievementDao;
    private UserDao userDao;
    private PasswordDao gDao;
    private AppDatabase db;


    @Before
    public void createDb(){
        Context context=InstrumentationRegistry.getTargetContext();
        db= Room.inMemoryDatabaseBuilder(context,AppDatabase.class).build();
        gDao=db.passwordDao();
        achievementDao=db.achievementDao();
        userAchievementDao=db.userAchievementDao();
        userDao= db.userDao();
    }

    @After
    public void closeDB(){
        db.close();
    }

    @Test
    public void useAppContext() throws Exception {
        PasswordModel game=new PasswordModel();

        gDao.insert(game);
        game.setId(1);
        PasswordModel gamedb= gDao.getById(1);
        assertEquals(gamedb.getId(),game.getId());
    }

    @Test
    public void testAchievementInsert() throws Exception{
        UserModel userModel=new UserModel("Razvan");
        long userId=userDao.insertGetLong(userModel);

        AchievementModel achievementModel1=new AchievementModel();
        achievementModel1.setLanguage("DE");
        long achId1=achievementDao.insertGetLong(achievementModel1);

        AchievementModel achievementModel2=new AchievementModel();
        achievementModel2.setLanguage("DE");
        long achId2=achievementDao.insertGetLong(achievementModel2);

        UserAchievementModel userAchievementModel=new UserAchievementModel(userId,achId1,new Date());
        userAchievementDao.insert(userAchievementModel);

        List<AchievementModel> list=userAchievementDao.getAllAchievedWithLanguage(userId,"DE"); //change language for different tests

        assertEquals(1,list.size());

    }

}
