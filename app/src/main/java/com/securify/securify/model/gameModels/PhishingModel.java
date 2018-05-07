package com.securify.securify.model.gameModels;

import android.arch.persistence.room.Entity;

/**
 * Created by Alwin on 06.05.2018.
 */

@Entity(tableName = "phishingspiel")
public class PhishingModel extends GameModel {

    String absender;
    String betreff;
    boolean is_phishing;


    public String getAbsender() {
        return absender;
    }

    public void setAbsender(String absender) {
        this.absender = absender;
    }

    public String getBetreff() {
        return betreff;
    }

    public void setBetreff(String betreff) {
        this.betreff = betreff;
    }

    public boolean isIs_phishing() {
        return is_phishing;
    }

    public void setIs_phishing(boolean is_phishing) {
        this.is_phishing = is_phishing;
    }
}
