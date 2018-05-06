package com.securify.securify.gameModels;

import android.arch.persistence.room.Entity;

/**
 * Created by Alwin on 06.05.2018.
 */

@Entity(tableName = "permissionspiel")
public class PermissionModel extends GameModel {

    boolean kamera;
    boolean position;
    boolean mikrofon;
    boolean kontake;
    boolean speicher;
    boolean sensoren;

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

    public boolean isSpeicher() {
        return speicher;
    }

    public void setSpeicher(boolean speicher) {
        this.speicher = speicher;
    }

    public boolean isSensoren() {
        return sensoren;
    }

    public void setSensoren(boolean sensoren) {
        this.sensoren = sensoren;
    }
}
