package com.securify.securify.database;


import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.gameModels.PermissionModel;
import com.securify.securify.model.gameModels.PhishingModel;
import com.securify.securify.model.userModels.UserModel;
import com.securify.securify.model.userModels.UserPermissionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alwin on 06.05.2018.
 */

public class PopulationFactory {

    public List<PasswordModel> getPasswordModels(){
        PasswordModel model=new PasswordModel();

        model.setId(1);
        model.setMax_length(15);
        model.setMin_length(5);
        model.setMin_number(1);
        model.setMin_upper(1);
        model.setKontext("Du willst dir ein neues Facebook passwort erstellen!");
        model.setSchwierigkeit("default");
        model.setSprache("DE");
        model.setTipp("Sonderzeichen sind immer gut!");
        model.setZeit(55);

        List<PasswordModel> list= new ArrayList<>();
        list.add(model);
        return list;
    }

    public List<PermissionModel> getPermissionModels(){
        PermissionModel model=new PermissionModel();


        model.setId(1);
        model.setKamera(true);
        model.setKontake(false);
        model.setMikrofon(false);
        model.setPosition(true);
        model.setSms(false);
        model.setErklaerung("Das ist eine Erklaerung die dir sagt was du falsch gemach hast");
        model.setZeit(15);  //15 sekunden Zeit
        model.setSprache("DE"); //Sprache ist Deutsch
        model.setKontext("Du Willst eine Foto App isntallieren die zusätzlich noch den Ort deiner Fotos speichert");
        model.setSchwierigkeit("default");
        model.setTipp("Um den Ort zu speichern muss die App wissen wo du dich gerade befindest");

        List<PermissionModel> list=new ArrayList<>();
        list.add(model);
        return list;
    }

    public List<PhishingModel> getPhishingModels(){
        PhishingModel model=new PhishingModel();

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

        List<PhishingModel> list=new ArrayList<>();
        list.add(model);
        
        return list;
    }

    public List<UserModel> getUserModels(){
        UserModel model=new UserModel();

        //set all test values
        model.setId(1);
        model.setName("Razvan");
        model.setPasswordHighscore(0);
        model.setPermissionHighscore(0);
        model.setPhishingHighscore(0);


        List<UserModel> list=new ArrayList<>();
        list.add(model);

        return list;
    }

}
