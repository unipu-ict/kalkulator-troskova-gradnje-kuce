package com.example.goran.projektkalkulatorzaizgradnjukuce.model;

public abstract class Krov extends BaseClass {

    private Double kvadratura = 0.0;


    public Double getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(Double kvadratura) {
        this.kvadratura = kvadratura;
        valueChanged();
    }

}
