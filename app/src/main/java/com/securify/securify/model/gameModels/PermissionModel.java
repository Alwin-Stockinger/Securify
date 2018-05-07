package com.securify.securify.model.gameModels;

import android.arch.persistence.room.Entity;

/**
 * Created by Alwin on 06.05.2018.
 */

@Entity(tableName = "permissionspiel")
public class PermissionModel extends GameModel {

    private boolean kamera;
    private boolean position;
    private boolean mikrofon;
    private boolean kontake;
    private boolean sms;
    

    public boolean isSms() {
        return sms;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }

    public boolean isKamera() {
        return kamera;
    }

    public void setKamera(boolean kamera) {
        this.kamera = kamera;
    }

    public boolean isPosition() {
        return position;
    }

    public void setPosition(boolean position) {
        this.position = position;
    }

    public boolean isMikrofon() {
        return mikrofon;
    }

    public void setMikrofon(boolean mikrofon) {
        this.mikrofon = mikrofon;
    }

    public boolean isKontake() {
        return kontake;
    }

    public void setKontake(boolean kontake) {
        this.kontake = kontake;
    }
}
