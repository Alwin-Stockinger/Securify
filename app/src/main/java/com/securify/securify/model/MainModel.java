package com.securify.securify.model;

import android.content.Context;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.PasswordDao;
import com.securify.securify.gameModels.PasswordModel;

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

        //test populate
        pInsert();
    }

    public PasswordModel getPassGameById(long id){
        return gamePicker.getPassGameById(id);
    }

    //test retrieve
    public PasswordModel getMaxPassGame(){
        PasswordDao dao=db.passwordDao();
        return dao.getMax();
    }

    //testinset
    private void pInsert(){
        PasswordDao dao=db.passwordDao();
        PasswordModel model=new PasswordModel();
        dao.deleteGame(1);
        model.setId(1);

        model.setMax_length(15);
        model.setMin_length(5);
        model.setMin_number(1);
        model.setMin_upper(1);


        dao.insertGame(model);
    }


}
