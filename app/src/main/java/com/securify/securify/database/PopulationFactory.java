package com.securify.securify.database;


import com.securify.securify.model.achievementModels.AchievementModel;
import com.securify.securify.model.gameModels.PasswordModel;
import com.securify.securify.model.gameModels.PermissionModel;
import com.securify.securify.model.gameModels.PhishingModel;
import com.securify.securify.model.userModels.UserModel;

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
        model.setAbsender("from: sparkasse_oesterreich@gmail.com");
        model.setBetreff("Aktualisierung Kundendatenbank");
        model.setIs_phishing(true);
        model.setErklaerung("Die Rechtschreibung alleine zeigt, dass etwas an der E-Mail nicht passt. Außerdem würde die Bank niemals auf diese Weise (also per Mail) nach Ihren Bankdaten fragen!");
        model.setZeit(40);  //40 sekunden Zeit
        model.setSprache("DE"); //Sprache ist Deutsch
        model.setKontext("Sehr geehrte Kundin, sehr geehrter Kunde,\n" +
                "\n" +
                "Der technische Dienst der Bank fuhrt die planmassige Aktualisierung der Software durch. Fur die Aktualisierung der Kundendatenbank ist es notig, Ihre Bankdaten erneut zu bestatigen. Dafuer muessen Sie unseren Link (unten) besuchen, wo Ihnen eine spezielle Form zum Ausfullen angeboten wird. \n" +
                "\n" +
                "https://www.sparkasse.de/firmenkunden/B_electronic-banking/online_banking_cud.html\n" +
                "\n" +
                "Diese Anweisung wird an alle Bankkunden gesandt und ist zum Erfullen erfoderlich.\n" +
                "\n" +
                "Wir bitten um Verstandnis und bedanken uns fur die Zusammenarbeit.\n");
        model.setSchwierigkeit("default");
        model.setTipp("Rechtschreibung beachten!");

        List<PhishingModel> list=new ArrayList<>();
        list.add(model);
        
        return list;
    }


    //Users
    public List<UserModel> getUserModels(){

        //set all values
        UserModel model1=new UserModel("Razvan");
        model1.setPasswordHighscore(9001);
        model1.setPermissionHighscore(0);
        model1.setPhishingHighscore(0);
        model1.setLanguage("DE");
        model1.setActive(true);


        UserModel model2=new UserModel("Alwin");
        model2.setPasswordHighscore(1);
        model2.setPermissionHighscore(1);
        model2.setPhishingHighscore(2);
        model2.setLanguage("DE");
        model2.setActive(false);

        UserModel model3=new UserModel("Lujza");
        model3.setPasswordHighscore(5);
        model3.setPermissionHighscore(3);
        model3.setPhishingHighscore(2);
        model3.setLanguage("DE");
        model3.setActive(false);

        UserModel model4=new UserModel("Yasin (der König)");
        model4.setPasswordHighscore(10);
        model4.setPermissionHighscore(21);
        model4.setPhishingHighscore(50);
        model4.setLanguage("DE");
        model4.setActive(false);

        UserModel model5=new UserModel("Vitor");
        model5.setPasswordHighscore(20);
        model5.setPermissionHighscore(20);
        model5.setPhishingHighscore(20);
        model5.setLanguage("EN");
        model5.setActive(false);

        List<UserModel> list=new ArrayList<>();
        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);
        list.add(model5);

        return list;
    }


    //Achievements

    public List<AchievementModel> getAchievementModels(){

        AchievementModel ach1=new AchievementModel();
        ach1.setTitle("Passwort Expterte");
        ach1.setContext("Erreiche über 70% beim Passwortspiel");
        ach1.setDifficulty("EASY");
        ach1.setLanguage("DE");

        AchievementModel ach2=new AchievementModel();
        ach2.setTitle("Passwort Spezialist");
        ach2.setContext("Erreiche über 65% beim Passwortspiel mit weniger als 2 Sonderzeichen");
        ach2.setDifficulty("MEDIUM");
        ach2.setLanguage("DE");

        List<AchievementModel> list=new ArrayList<>();
        list.add(ach1);
        list.add(ach2);


        return list;
    }

}
