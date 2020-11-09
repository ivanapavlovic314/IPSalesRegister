/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ivana
 */
public class Ugovor {

    private final IntegerProperty broj = new SimpleIntegerProperty(this, "broj", 0);
    private final StringProperty imeiprezime = new SimpleStringProperty(this, "imeiprezime", "");
    private final StringProperty adresa = new SimpleStringProperty(this, "adresa", "");
    private final StringProperty trajanje = new SimpleStringProperty(this, "trajanje", "");
    private final StringProperty brzina = new SimpleStringProperty(this, "brzina", "");
    private final StringProperty protok = new SimpleStringProperty(this, "protok", "");

    public Ugovor() {

    }

    public Ugovor(Integer broj, String imeiprezime, String adresa, String trajanje, String brzina, String protok) {
        setBroj(broj);
        setImeiprezime(imeiprezime);
        setAdresa(adresa);
        setTrajanje(trajanje);
        setBrzina(brzina);
        setProtok(protok);
    }

    public Integer getBroj() {
        return broj.get();
    }

    public void setBroj(Integer brojU) {
        broj.set(brojU);
    }

    public String getImeiprezime() {
        return imeiprezime.get();
    }

    public void setImeiprezime(String iip) {
        imeiprezime.set(iip);
    }

    public String getAdresa() {
        return adresa.get();
    }

    public void setAdresa(String adr) {
        adresa.set(adr);
    }

    public String getTrajanje() {
        return trajanje.get();
    }

    public void setTrajanje(String traj) {
        trajanje.set(traj);
    }

    public String getBrzina() {
        return brzina.get();
    }

    public void setBrzina(String brz) {
        brzina.set(brz);
    }
    
    public String getProtok() {
        return protok.get();
    }

    public void setProtok(String prt) {
        protok.set(prt);
    }

    @Override
    public String toString() {
        return "Ugovor{" + "broj=" + broj + ", imeiprezime=" + imeiprezime + ", adresa=" + adresa + ", trajanje=" + trajanje + ", brzina=" + brzina + ", protok=" + protok + '}';
    }

}
