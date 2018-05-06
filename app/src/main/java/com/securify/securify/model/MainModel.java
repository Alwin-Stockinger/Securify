package com.securify.securify.model;

import android.content.Context;

import com.securify.securify.database.AppDatabase;
import com.securify.securify.database.PasswordDao;
import com.securify.securify.database.PermissionDao;
import com.securify.securify.database.PhishingDao;
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

        //test populate
        pInsert();
        permInsert();
        phishInsert();

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



    private void permInsert(){
        PermissionDao dao=db.permissionDao();
        PermissionModel model=new PermissionModel();
        dao.deleteGame(1);      //Delete old Game with ID 1 from DB

        //set all test values
        model.setId(1);
        model.setKamera(true);
        model.setKontake(false);
        model.setMikrofon(false);
        model.setPosition(true);
        model.setSensoren(false);
        model.setSpeicher(true);
        model.setErklaerung("Das ist eine Erklaerung die dir sagt was du falsch gemach hast");
        model.setZeit(50);  //50 sekunden Zeit
        model.setSprache("DE"); //Sprache ist Deutsch
        model.setKontext("Du Willst eine Foto App isntallieren die zusätzlich noch den Ort deiner Fotos speichert");
        model.setSchwierigkeit("default");
        model.setTipp("Um den Ort zu speichern muss die App wissen wo du dich gerade befindest");

        dao.insertGame(model);  //insert into DB
    }

    private void phishInsert(){
        PhishingDao dao=db.phishingDao();
        PhishingModel model=new PhishingModel();
        dao.deleteGame(1);      //Delete old Game with ID 1 from DB

        //set all test values
        model.setId(1);
        model.setAbsender("Ich bin der Absender");
        model.setBetreff("Ich bin der Betreff");
        model.setIs_phishing(true);
        model.setErklaerung("Das ist eine Erklaerung die dir sagt was du falsch gemach hast");
        model.setZeit(50);  //50 sekunden Zeit
        model.setSprache("DE"); //Sprache ist Deutsch
        model.setKontext("Ich bin ein gemeiner schurke und möchte deine Kreditkarte stehlen, also schick mir bitte deine Kreditkartennummer und deine PIN");
        model.setSchwierigkeit("default");
        model.setTipp("Schurken sollten man nicht trauen!");

        dao.insertGame(model);  //insert into DB
    }







}
