package com.rankend.barankaraboa.vkeproject;

/**
 * Created by Baran on 31.03.2017.
 */

public class uygModel {

    String sonuc,kilo,boy,isim;
    public uygModel(){}


    public uygModel(String boy, String kilo, String sonuc,String isim) {
        this.isim = isim;
        this.boy = boy;
        this.kilo = kilo;
        this.sonuc = sonuc;
    }

    public String getIsim() { return isim; }

    public String getBoy() {
        return boy;
    }

    public void setBoy(String boy) {
        this.boy = boy;
    }

    public String getKilo() {
        return kilo;
    }

    public void setKilo(String kilo) {
        this.kilo = kilo;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }
}
