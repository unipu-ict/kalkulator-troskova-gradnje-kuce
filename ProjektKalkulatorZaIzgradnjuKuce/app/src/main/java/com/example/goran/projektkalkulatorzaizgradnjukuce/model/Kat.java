package com.example.goran.projektkalkulatorzaizgradnjukuce.model;

import android.text.Editable;

public class Kat extends BaseClass {

    private Boolean drugiKatIsti = false;
    private Boolean porobeton = false;
    private Integer brojDimnjaka = 0;
    private Double pregradniZidovi = 0.0;
    private Double kvadratura = 0.0;


    public Boolean getDrugiKatIsti() {
        return drugiKatIsti;
    }

    public void setDrugiKatIsti(Boolean drugiKatIsti) {
        this.drugiKatIsti = drugiKatIsti;
        valueChanged();
    }

    public Boolean getPorobeton() {
        return porobeton;
    }

    public void setPorobeton(Boolean porobeton) {
        this.porobeton = porobeton;
        valueChanged();
    }

    public Integer getBrojDimnjaka() {
        return brojDimnjaka;
    }

    public void setBrojDimnjaka(Integer brojDimnjaka) {
        this.brojDimnjaka = brojDimnjaka;
        valueChanged();
    }

    public Double getPregradniZidovi() {
        return pregradniZidovi;
    }

    public void setPregradniZidovi(Double pregradniZidovi) {
        this.pregradniZidovi = pregradniZidovi;
        valueChanged();
    }

    public Double getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(Double kvadratura) {
        this.kvadratura = kvadratura;
        valueChanged();
    }


    public Double getTotalPregradniZidovi(){
        if (pregradniZidovi!=null){
            return pregradniZidovi * 59.40;
        }
        return 0.0;
    }

    public Double getTotalDimjak(){
        if (brojDimnjaka!=null){
            return (double)brojDimnjaka*360;
        }
        return 0.0;
    }
    public Double getTotalPorobeton(){
        if(porobeton==null)
            return 0.0;

        if (porobeton)
            return kvadratura == null? 0.0 : kvadratura*124;

        else
           return kvadratura == null? 0.0 : kvadratura * 94;
    }

    public Double getTotalDrugiKat(){
        if (drugiKatIsti!=null && drugiKatIsti)
            return getTotalPrviKat();

        return 0.0;
    }
    private Double getTotalPrviKat(){
        return getTotalPregradniZidovi() + getTotalDimjak() + getTotalPorobeton();
    }

    @Override
    public Double getTotal() {
        return getTotalPrviKat() + getTotalDrugiKat();
    }
}
