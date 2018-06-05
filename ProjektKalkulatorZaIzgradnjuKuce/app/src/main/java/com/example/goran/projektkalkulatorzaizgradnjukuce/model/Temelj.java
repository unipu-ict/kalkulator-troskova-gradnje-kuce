package com.example.goran.projektkalkulatorzaizgradnjukuce.model;

public class Temelj extends BaseClass {

    private Double kvadratura = 0.0;
    private Double visinaNadtemelja = 0.0;
    private Double nagibTerena = 0.0;

    public Double getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(Double kvadratura) {
        this.kvadratura = kvadratura;
        valueChanged();
    }

    public Double getVisinaNadtemelja() {
        return visinaNadtemelja;
    }

    public void setVisinaNadtemelja(Double visinaNadtemelja) {
        this.visinaNadtemelja = visinaNadtemelja;
        valueChanged();
    }

    public Double getNagibTerena() {
        return nagibTerena;
    }

    public void setNagibTerena(Double nagibTerena) {
        this.nagibTerena = nagibTerena;
        valueChanged();
    }

    public Double getTotalNagibTerena(){
        if(nagibTerena!= null)
            return nagibTerena * 2;

        return 0.0;
    }

    public Double getTotalVisinaNadtemelja(){
        if (visinaNadtemelja != null)
            return visinaNadtemelja * 4.3;

        return 0.0;
    }

    @Override
    public Double getTotal() {
        if (kvadratura==null)
            kvadratura=0.0;

        return kvadratura * 82 + getTotalNagibTerena() + getTotalVisinaNadtemelja();
    }
}
