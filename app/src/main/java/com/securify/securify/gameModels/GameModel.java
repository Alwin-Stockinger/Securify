package com.securify.securify.gameModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Alwin on 27.04.2018.
 */

@Entity
public class GameModel {
    @PrimaryKey(autoGenerate = true)
    private long  id;

    private String tipp;
    private String schwierigkeit;
    private String kontext;
    private String sprache;
    private int zeit;
    private String erklaerung;



    public void setId(long id) {
        this.id = id;
    }

    public String getTipp() {
        return tipp;
    }

    public void setTipp(String tipp) {
        this.tipp = tipp;
    }

    public String getSchwierigkeit() {
        return schwierigkeit;
    }

    public void setSchwierigkeit(String schwierigkeit) {
        this.schwierigkeit = schwierigkeit;
    }

    public String getKontext() {
        return kontext;
    }

    public void setKontext(String kontext) {
        this.kontext = kontext;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public int getZeit() {
        return zeit;
    }

    public void setZeit(int zeit) {
        this.zeit = zeit;
    }

    public String getErklaerung() {
        return erklaerung;
    }

    public void setErklaerung(String erklaerung) {
        this.erklaerung = erklaerung;
    }

    public long getId() {
        return id;
    }
}
