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
        PasswordModel model1=new PasswordModel();
        model1.setMax_length(15);
        model1.setMin_length(5);
        model1.setMin_number(1);
        model1.setMin_upper(1);
        model1.setKontext("Du willst dir ein neues Facebook Passwort erstellen!");
        model1.setSchwierigkeit("EASY");
        model1.setSprache("DE");
        model1.setTipp("Sonderzeichen sind immer gut!");
        model1.setZeit(55);

        PasswordModel model2=new PasswordModel();
        model2.setMax_length(10);
        model2.setMin_length(7);
        model2.setMin_number(3);
        model2.setMin_upper(2);
        model2.setKontext("Du willst dir ein neues Twitter Passwort erstellen");
        model2.setSchwierigkeit("MEDIUM");
        model2.setSprache("DE");
        model2.setTipp("Sonderzeichen sind immer gut!");
        model2.setZeit(30);

        PasswordModel model3=new PasswordModel();
        model3.setMax_length(20);
        model3.setMin_length(13);
        model3.setMin_number(12);
        model3.setMin_upper(1);
        model3.setKontext("Du willst dir ein Passwort für Google erstellen!");
        model3.setSchwierigkeit("HARD");
        model3.setSprache("DE");
        model3.setTipp("Sonderzeichen sind immer gut!");
        model3.setZeit(10);


        List<PasswordModel> list= new ArrayList<>();
        list.add(model1);
        list.add(model2);
        list.add(model3);
        return list;
    }

    public List<PermissionModel> getPermissionModels(){


        PermissionModel model1=new PermissionModel();
        model1.setKamera(true);
        model1.setKontake(false);
        model1.setMikrofon(false);
        model1.setPosition(true);
        model1.setSms(false);
        model1.setErklaerung("Um den Ort zu speichern braucht die ob deine Position und für die Fotos die Kamera");
        model1.setZeit(15);  //15 sekunden Zeit
        model1.setSprache("DE"); //Sprache ist Deutsch
        model1.setKontext("Du Willst eine Foto App installieren die zusätzlich noch den Ort deiner Fotos speichert");
        model1.setSchwierigkeit("EASY");
        model1.setTipp("Um den Ort zu speichern muss die App wissen wo du dich gerade befindest");

        PermissionModel model2=new PermissionModel();
        model2.setKamera(false);
        model2.setKontake(false);
        model2.setMikrofon(false);
        model2.setPosition(false);
        model2.setSms(true);
        model2.setErklaerung("Die App muss auf deine SMS zugreifen können um diese zu verschicken. Da du nicht an den Sprachnachrichten interessiert bist, solltest du das Mikrofon nicht erlauben.");
        model2.setZeit(10);
        model2.setSprache("DE"); //Sprache ist Deutsch
        model2.setKontext("Du willst eine neue Messenger App herunterladen, die auch SMS verschicken kann, zusätzlich kann die App auch Sprachnachrichten aufnehmen und verscicken, woran du aber nicht interessiert bist.");
        model2.setSchwierigkeit("MEDIUM");
        model2.setTipp("Was dich nicht interessiert solltest du auch nicht erlauben!");

        PermissionModel model3=new PermissionModel();
        model3.setKamera(true);
        model3.setKontake(false);
        model3.setMikrofon(false);
        model3.setPosition(true);
        model3.setSms(false);
        model3.setErklaerung("Mikrofon und Kamera sind nötig um Videos mit Ton aufzunehemen. Deine Kontakte werden gebraucht um damit die App deine Freunde in den Videos markieren kann");
        model3.setZeit(5);
        model3.setSprache("DE"); //Sprache ist Deutsch
        model3.setKontext("Du Willst eine Video aufnahme App installieren, die die Funktion hat Freunde die du als Kontakte am Handy mit Bild eingespeichert hast im Video zu markieren");
        model3.setSchwierigkeit("HARD");
        model3.setTipp("Videos brauchen Ton!");

        List<PermissionModel> list=new ArrayList<>();
        list.add(model1);
        list.add(model2);
        list.add(model3);

        return list;
    }

    public List<PhishingModel> getPhishingModels(){


        PhishingModel model1=new PhishingModel();
        model1.setAbsender("from: sparkasse_oesterreich@gmail.com");
        model1.setBetreff("Aktualisierung Kundendatenbank");
        model1.setIs_phishing(true);
        model1.setErklaerung("Die Rechtschreibung alleine zeigt, dass etwas an der E-Mail nicht passt. Außerdem würde die Bank niemals auf diese Weise (also per Mail) nach Ihren Bankdaten fragen!");
        model1.setZeit(40);  //40 sekunden Zeit
        model1.setSprache("DE"); //Sprache ist Deutsch
        model1.setKontext("Sehr geehrte Kundin, sehr geehrter Kunde,\n" +
                "\n" +
                "Der technische Dienst der Bank fuhrt die planmassige Aktualisierung der Software durch. Fur die Aktualisierung der Kundendatenbank ist es notig, Ihre Bankdaten erneut zu bestatigen. Dafuer muessen Sie unseren Link (unten) besuchen, wo Ihnen eine spezielle Form zum Ausfullen angeboten wird. \n" +
                "\n" +
                "https://www.sparkasse.de/firmenkunden/B_electronic-banking/online_banking_cud.html\n" +
                "\n" +
                "Diese Anweisung wird an alle Bankkunden gesandt und ist zum Erfullen erfoderlich.\n" +
                "\n" +
                "Wir bitten um Verstandnis und bedanken uns fur die Zusammenarbeit.\n");
        model1.setSchwierigkeit("EASY");
        model1.setTipp("Rechtschreibung beachten!");


        List<PhishingModel> list=new ArrayList<>();
        list.add(model1);
        
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
        ach1.setId(1);
        ach1.setTitle("Passwort Expterte");
        ach1.setContext("Erreiche über 70% beim Passwortspiel");
        ach1.setDifficulty("EASY");
        ach1.setLanguage("DE");

        AchievementModel ach2=new AchievementModel();
        ach2.setId(2);
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
