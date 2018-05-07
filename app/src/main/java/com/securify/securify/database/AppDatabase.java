package com.securify.securify.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.securify.securify.database.daos.userDaos.UserDao;
import com.securify.securify.database.daos.gameDaos.PasswordDao;
import com.securify.securify.database.daos.gameDaos.PermissionDao;
import com.securify.securify.database.daos.gameDaos.PhishingDao;
import com.securify.securify.database.daos.userDaos.UserPasswordDao;
import com.securify.securify.database.daos.userDaos.UserPermissionDao;
import com.securify.securify.model.userModels.UserModel;
import com.securify.securify.model.gameModels.GameModel;
import com.securify.securify.model.otherModels.Config;
import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.gameModels.PermissionModel;
import com.securify.securify.model.otherModels.Persona;
import com.securify.securify.model.gameModels.PhishingModel;
import com.securify.securify.model.otherModels.Question;
import com.securify.securify.model.otherModels.Quiz;
import com.securify.securify.model.otherModels.Score;
import com.securify.securify.model.userModels.UserPasswordModel;
import com.securify.securify.model.userModels.UserPermissionModel;

/**
 * Created by Alwin on 27.04.2018.
 */

@Database(version = 1,entities = {
                                PasswordModel.class,
                                PermissionModel.class,
                                PhishingModel.class,
                                UserModel.class,
                                UserPermissionModel.class,
                                UserPasswordModel.class,

                                GameModel.class,
                                Persona.class,
                                Config.class,
                                Quiz.class,
                                Question.class,
                                Score.class
                                })
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    //DAOs
    //game daos
    abstract public PasswordDao passwordDao();
    abstract public PermissionDao permissionDao();
    abstract public PhishingDao phishingDao();

    //user daos
    abstract public UserDao userDao();
    abstract public UserPermissionDao userPermissionDao();
    abstract public UserPasswordDao userPasswordDao();



    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (AppDatabase.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"game_db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
