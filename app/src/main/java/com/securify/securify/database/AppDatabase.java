package com.securify.securify.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.securify.securify.gameModels.Config;
import com.securify.securify.gameModels.GameModel;
import com.securify.securify.gameModels.PasswordModel;
import com.securify.securify.gameModels.PermissionModel;
import com.securify.securify.gameModels.Persona;
import com.securify.securify.gameModels.PhishingModel;
import com.securify.securify.gameModels.Question;
import com.securify.securify.gameModels.Quiz;
import com.securify.securify.gameModels.Score;

/**
 * Created by Alwin on 27.04.2018.
 */

@Database(version = 1,entities = {GameModel.class, PasswordModel.class, PermissionModel.class, PhishingModel.class, Persona.class, Config.class, Quiz.class, Question.class, Score.class})
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    abstract public GameModelDao gameModelDao();
    abstract public PasswordDao passwordDao();
    abstract public PermissionDao permissionDao();
    abstract public PhishingDao phishingDao();


    private static AppDatabase INSTANCE;


    public static synchronized AppDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (AppDatabase.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"game_db")
                            .allowMainThreadQueries()
                            /*.addCallback(new Callback() {   //prepopulate Database
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            PopulationFactory factory=new PopulationFactory();
                                            INSTANCE.phishingDao().insertAll(factory.getPhishingModels());
                                            INSTANCE.permissionDao().insertAll(factory.getPermissionModels());
                                            INSTANCE.passwordDao().insertAll(factory.getPasswordModels());
                                        }
                                    });
                                }
                            })*/
                            .build();
                }
            }
        }
        return INSTANCE;/*Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"game_db")
                .addCallback(new Callback() {   //prepopulate Database
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        PopulationFactory factory=new PopulationFactory();
                        INSTANCE.phishingDao().insertAll(factory.getPhishingModels());
                        INSTANCE.permissionDao().insertAll(factory.getPermissionModels());
                        INSTANCE.passwordDao().insertAll(factory.getPasswordModels());
                    }
                })
                .allowMainThreadQueries()
                .build();//INSTANCE;*/
    }

    /*private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };


    public static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {

        private final GameModelDao gameDao;

        PopulateDbAsync(AppDatabase db){
            gameDao=db.gameModelDao();
        }



        @Override
        protected Void doInBackground(final Void... params) {
            GameModel game = new GameModel();
            //Lujza: did not compile so I had to comment it out
            //game.id=1;
            gameDao.insertGame(game);
            return null;
        }
    }*/

}
