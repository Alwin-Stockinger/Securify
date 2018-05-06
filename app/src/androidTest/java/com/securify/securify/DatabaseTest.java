package com.securify.securify;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.GameModelDao;
import com.securify.securify.gameModels.GameModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private GameModelDao gDao;
    private AppDatabase db;

    @Before
    public void createDb(){
        Context context=InstrumentationRegistry.getTargetContext();
        db= Room.inMemoryDatabaseBuilder(context,AppDatabase.class).build();
        gDao=db.gameModelDao();
    }

    @After
    public void closeDB(){
        db.close();
    }

    @Test
    public void useAppContext() throws Exception {
        GameModel game=new GameModel();

        gDao.insertGame(game);
        List<GameModel> list= gDao.getAllGames();
        assertEquals(list.get(0).getId(),game.getId());
    }
}
