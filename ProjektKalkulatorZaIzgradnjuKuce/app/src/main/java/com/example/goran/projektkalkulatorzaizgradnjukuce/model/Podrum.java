package com.example.goran.projektkalkulatorzaizgradnjukuce.model;


public class Podrum extends BaseClass {

    private Double kvadratura = 0.0;
    private Double dubinaIskopa = 0.0;
    private Double sirina = 0.0;
    private Double duzina = 0.0;
    private Boolean hidroizolacija = false;
    private Boolean iskopPodruma = false;
    private Boolean drenaza = false;


    public Double getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(Double kvadratura) {
        this.kvadratura = kvadratura;
        valueChanged();
    }

    public Double getDubinaIskopa() {
        return dubinaIskopa;
    }

    public void setDubinaIskopa(Double dubinaIskopa) {
        this.dubinaIskopa = dubinaIskopa;
        valueChanged();
    }

    public Double getSirina() {
        return sirina;
    }

    public void setSirina(Double sirina) {
        this.sirina = sirina;
        valueChanged();
    }

    public Double getDuzina() {
        return duzina;
    }

    public void setDuzina(Double duzina) {
        this.duzina = duzina;
        valueChanged();
    }

    public Boolean getHidroizolacija() {
        return hidroizolacija;
    }

    public void setHidroizolacija(Boolean hidroizolacija) {
        this.hidroizolacija = hidroizolacija;
        valueChanged();
    }

    public Boolean getIskopPodruma() {
        return iskopPodruma;
    }

    public void setIskopPodruma(Boolean iskopPodruma) {
        this.iskopPodruma = iskopPodruma;
        valueChanged();
    }

    public Boolean getDrenaza() {
        return drenaza;
    }

    public void setDrenaza(Boolean drenaza) {
        this.drenaza = drenaza;
        valueChanged();
    }

    public Double getTotalDrenaza(){
        if(drenaza && duzina!=null && sirina!=null)
            return (duzina * 22) + (sirina *22);

        return 0.0;
    }

    public Double getTotalIskopPodruma(){
        if(iskopPodruma && dubinaIskopa!= null)
                return dubinaIskopa * 120;

        return 0.0;
    }
    public Double getTotalHidroizolacija(){
        if(hidroizolacija && sirina != null && duzina != null)
            return 0.2 * sirina * duzina;

        return 0.0;
    }

    @Override
    public Double getTotal(){
        if (kvadratura == null)
            kvadratura = 0.0;

        return (kvadratura*220) + getTotalDrenaza() + getTotalIskopPodruma() + getTotalHidroizolacija();

    }
}
