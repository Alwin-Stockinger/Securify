package com.securify.securify.database;

import android.app.Application;
import android.os.AsyncTask;

import com.securify.securify.gameModels.GameModel;

/**
 * Created by Alwin on 27.04.2018.
 */

public class GameRepository {

    private GameModelDao gameDao;


    public GameRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        gameDao = db.gameModelDao();
    }

    public void insert (GameModel game){
        new insertAsyncTask(gameDao).execute(game);
    }





    private static class insertAsyncTask extends AsyncTask<GameModel, Void, Void> {

        private GameModelDao mAsyncTaskDao;

        insertAsyncTask(GameModelDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GameModel... params) {
            mAsyncTaskDao.insertGame(params[0]);
            return null;
        }
    }
}

