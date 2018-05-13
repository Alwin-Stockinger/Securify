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
        PasswordModel model2=new PasswordModel();
        model2.setMax_length(10);
        model2.setMin_length(7);
        model2.setMin_number(3);
        model2.setMin_upper(2);
        model2.setKontext("Du willst dir ein neues Twitter-Passwort erstellen");
        model2.setSchwierigkeit("EASY");
        model2.setSprache("DE");
        model2.setTipp("Sonderzeichen sind immer gut!");
        model2.setZeit(30);

        PasswordModel model1=new PasswordModel();
        model1.setMax_length(15);
        model1.setMin_length(5);
        model1.setMin_number(1);
        model1.setMin_upper(1);
        model1.setKontext("Du willst dir ein neues Facebook-Passwort erstellen!");
        model1.setSchwierigkeit("MEDIUM");
        model1.setSprache("DE");
        model1.setTipp("Sonderzeichen sind immer gut!");
        model1.setZeit(55);

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
        model1.setErklaerung("Um den Ort zu speichern braucht die App deine Position und für die Fotos die Kamera");
        model1.setZeit(24);  //15 sekunden Zeit
        model1.setSprache("DE"); //Sprache ist Deutsch
        model1.setKontext("Du Willst eine Foto-App installieren die zusätzlich noch den Ort deiner Fotos speichert");
        model1.setSchwierigkeit("EASY");
        model1.setTipp("Um den Ort zu speichern muss die App wissen wo du dich gerade befindest");

        PermissionModel model2=new PermissionModel();
        model2.setKamera(false);
        model2.setKontake(false);
        model2.setMikrofon(false);
        model2.setPosition(false);
        model2.setSms(true);
        model2.setErklaerung("Die App muss auf deine SMS zugreifen können um diese zu verschicken. Da du nicht an den Sprachnachrichten interessiert bist, solltest du das Mikrofon nicht erlauben.");
        model2.setZeit(20);
        model2.setSprache("DE"); //Sprache ist Deutsch
        model2.setKontext("Du willst eine neue Messenger-App herunterladen, die auch SMS verschicken kann, zusätzlich kann die App auch Sprachnachrichten aufnehmen und verschicken, woran du aber nicht interessiert bist.");
        model2.setSchwierigkeit("MEDIUM");
        model2.setTipp("Was dich nicht interessiert, solltest du auch nicht erlauben!");

        PermissionModel model3=new PermissionModel();
        model3.setKamera(true);
        model3.setKontake(true);
        model3.setMikrofon(true);
        model3.setPosition(false);
        model3.setSms(false);
        model3.setErklaerung("Mikrofon und Kamera sind nötig um Videos mit Ton aufzunehemen. Deine Kontakte werden gebraucht, damit die App deine Freunde in den Videos markieren kann");
        model3.setZeit(18);
        model3.setSprache("DE"); //Sprache ist Deutsch
        model3.setKontext("Du Willst eine Videoaufnahme-App installieren, die die Funktion hat Freunde, die du als Kontakte am Handy mit Bild eingespeichert hast, im Video zu markieren");
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


        PhishingModel model2=new PhishingModel();
        model2.setAbsender("from: info@twitter.com");
        model2.setBetreff("An update on your account security");
        model2.setIs_phishing(false);
        model2.setErklaerung("Das ist eine echte Email die Twitter ausgesendet hat. Die Email hat weder Rechtschreibfehler noch ist der Absender von einer seltsamen Adresse und es befinden sich keine dubiosen Links in der E-Mail.");
        model2.setZeit(50);
        model2.setSprache("DE"); //Sprache ist Deutsch
        model2.setKontext("Hi ,\n" +
                "\n" +
                "When you set a password for your Twitter account, we use technology that masks it so no one at the company can see it. We recently identified a bug that stored passwords unmasked in an internal log. We have fixed the bug, and our investigation shows no indication of breach or misuse by anyone. \n" +
                "\n" +
                "Out of an abundance of caution, we ask that you consider changing your password on all services where you’ve used this password. You can change your Twitter password anytime by going to the password settings page.\n" +
                "\n" +
                "\n" +
                "About The Bug\n" +
                "\n" +
                "We mask passwords through a process called hashing using a function known as bcrypt, which replaces the actual password with a random set of numbers and letters that are stored in Twitter's system. This allows our systems to validate your account credentials without revealing your password. This is an industry standard.\n" +
                "\n" +
                "Due to a bug, passwords were written to an internal log before completing the hashing process. We found this error ourselves, removed the passwords, and are implementing plans to prevent this bug from happening again.\n" +
                "\n" +
                "\n" +
                "Tips on Account Security\n" +
                "\n" +
                "1.\t \tChange your password on Twitter and on any other service where you may have used the same password.\n" +
                "\n" +
                "2.\t \tUse a strong password that you don't reuse on other services.\n" +
                "\n" +
                "3.\t \tEnable login verification, also known as two factor authentication. This is the single best action you can take to increase your account security.\n" +
                "\n" +
                "4.\t \tUse a password manager to make sure you're using strong, unique passwords everywhere.\n" +
                "\n" +
                "We are very sorry this happened. We recognize and appreciate the trust you place in us, and are committed to earning that trust every day.\n" +
                "\n" +
                "Team Twitter\n");
        model2.setSchwierigkeit("MEDIUM");
        model2.setTipp("Erkennst du die Domain(das nach dem @) des Absenders?");


        List<PhishingModel> list=new ArrayList<>();
        list.add(model1);
        list.add(model2);
        
        return list;
    }


    //Users
    public List<UserModel> getUserModels(){

        //set all values
        UserModel model1=new UserModel("Razvan");
        model1.setPasswordHighscore(99);
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

        //PASSWORD ACHIEVEMENTS
        AchievementModel ach1=new AchievementModel();
        ach1.setId(1);
        ach1.setTitle("Passwort-Experte");
        ach1.setContext("Erreichen Sie über 60% beim Passwortspiel.");
        ach1.setDifficulty("EASY");
        ach1.setLanguage("DE");

        AchievementModel ach2=new AchievementModel();
        ach2.setId(2);
        ach2.setTitle("Passwort-Spezialist");
        ach2.setContext("Erreichen Sie über 65% beim Passwortspiel mit weniger als 3 Sonderzeichen.");
        ach2.setDifficulty("MEDIUM");
        ach2.setLanguage("DE");

        AchievementModel ach3=new AchievementModel();
        ach3.setId(3);
        ach3.setTitle("Passwort-Meister");
        ach3.setContext("Erreichen Sie über 70% beim Passwortspiel mit weniger als 3 Sonderzeichen und weniger als 3 Zahlen.");
        ach3.setDifficulty("HARD");
        ach3.setLanguage("DE");

        //PERMISSION ACHIEVEMENTS
        AchievementModel ach4=new AchievementModel();
        ach4.setId(4);
        ach4.setTitle("Zugriffe absichern");
        ach4.setContext("Beantworten Sie 2 Fragen hintereinander richtig.");
        ach4.setDifficulty("EASY");
        ach4.setLanguage("DE");

        AchievementModel ach5=new AchievementModel();
        ach5.setId(5);
        ach5.setTitle("Zugriffe schnell absichern");
        ach5.setContext("Beantworten Sie 2 Fragen hintereinander richtig, ohne länger als 50% der gegebenen Zeit für jedes Spiel zu benötigen.");
        ach5.setDifficulty("MEDIUM");
        ach5.setLanguage("DE");

        AchievementModel ach6 = new AchievementModel();
        ach6.setId(6);
        ach6.setTitle("Sicherheitsexperte");
        ach6.setContext("Beantworten Sie 3 Fragen hintereinander richtig, ohne länger als 30% der gegebenen Zeit für jedes Spiel zu benötigen.");
        ach6.setDifficulty("HARD");
        ach6.setLanguage("DE");

        //PHISHING ACHIEVEMENTS
        AchievementModel ach7=new AchievementModel();
        ach7.setId(7);
        ach7.setTitle("Betrüger erkennen");
        ach7.setContext("Erkennen Sie bei 1 Fallbeispiel die Echtheit/Fälschung der Mails korrekt.");
        ach7.setDifficulty("EASY");
        ach7.setLanguage("DE");

        AchievementModel ach8=new AchievementModel();
        ach8.setId(8);
        ach8.setTitle("Betrüger schnell erkennen");
        ach8.setContext("Erkennen Sie bei 2 Fallbeispielen die Echtheit/Fälschung der Mails korrekt, ohne länger als 40% der Zeit zu benötigen.");
        ach8.setDifficulty("MEDIUM");
        ach8.setLanguage("DE");

        AchievementModel ach9 = new AchievementModel();
        ach9.setId(9);
        ach9.setTitle("Mail-Experte");
        ach9.setContext("Erkennen Sie bei 2 Fallbeispielen hintereinander die Echtheit/Fälschung der Mails korrekt, ohne länger als 20% der Zeit zu benötigen und ohne den Tipp-Button zu betätigen.");
        ach9.setDifficulty("HARD");
        ach9.setLanguage("DE");

        List<AchievementModel> list=new ArrayList<>();
        list.add(ach1);
        list.add(ach2);
        list.add(ach3);
        list.add(ach4);
        list.add(ach5);
        list.add(ach6);
        list.add(ach7);
        list.add(ach8);
        list.add(ach9);


        return list;
    }

}
