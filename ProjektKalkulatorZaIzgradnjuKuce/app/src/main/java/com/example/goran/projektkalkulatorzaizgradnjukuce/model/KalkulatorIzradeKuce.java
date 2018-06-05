package com.example.goran.projektkalkulatorzaizgradnjukuce.model;

/**
 * Created by Goran on 26.5.2018..
 */

public class KalkulatorIzradeKuce extends BaseClass {

    private static KalkulatorIzradeKuce ourInstance = new KalkulatorIzradeKuce();

    private Double total = 0.0;

    private Kat kat;
    private Krov krov;
    private Podrum podrum;
    private Prizemlje prizemlje;
    private Temelj temelj;


    private KalkulatorIzradeKuce(){}


    public static KalkulatorIzradeKuce getInstance() {
        return ourInstance;
    }

    @Override
    public Double getTotal() {
        return total;
    }


    public Kat getKat() {
        if(kat == null){
            kat = new Kat();
            kat.setValueChangeListener(new ValueChangeListener() {
                @Override
                public void valueChanged() {
                    recalculate();
                }
            });
        }
        return kat;
    }

    public void setKat(Kat kat) {
        this.kat = kat;
        if(this.kat != null)
            this.kat.setValueChangeListener(new ValueChangeListener() {
                @Override
                public void valueChanged() {
                    recalculate();
                }
            });

    }

    public Krov getKrov() {
        /*Predlaganje?
        if(krov == null){
            krov = new KosiKrov();
            krov.setValueChangeListener(() -> recalculate());
        }*/
        return krov;
    }

    public void setKrov(Krov krov) {
        this.krov = krov;
        if(this.krov != null)
            this.krov.setValueChangeListener(new ValueChangeListener() {
                @Override
                public void valueChanged() {
                    recalculate();
                }
            });
    }

    public Podrum getPodrum() {
        if(podrum == null){
            podrum = new Podrum();
            podrum.setValueChangeListener(new ValueChangeListener() {
                @Override
                public void valueChanged() {
                    recalculate();
                }
            });
        }
        return podrum;
    }

    public void setPodrum(Podrum podrum) {
        this.podrum = podrum;
        if(this.podrum != null)
            this.podrum.setValueChangeListener(new ValueChangeListener() {
                @Override
                public void valueChanged() {
                    recalculate();
                }
            });
    }

    public Prizemlje getPrizemlje() {
        if(prizemlje == null){
            prizemlje = new Prizemlje();
            prizemlje.setValueChangeListener(new ValueChangeListener() {
                @Override
                public void valueChanged() {
                    recalculate();
                }
            });
        }
        return prizemlje;
    }

    public void setPrizemlje(Prizemlje prizemlje) {
        this.prizemlje = prizemlje;
        if(this.prizemlje != null)
            this.prizemlje.setValueChangeListener(new ValueChangeListener() {
                @Override
                public void valueChanged() {
                    recalculate();
                }
            });
    }

    public Temelj getTemelj() {
        if(temelj == null){
            temelj = new Temelj();
            temelj.setValueChangeListener(new ValueChangeListener() {
                @Override
                public void valueChanged() {
                    recalculate();
                }
            });
        }
        return temelj;
    }

    public void setTemelj(Temelj temelj) {
        this.temelj = temelj;
        if(this.temelj != null)
            this.temelj.setValueChangeListener(new ValueChangeListener() {
                @Override
                public void valueChanged() {
                    recalculate();
                }
            });
    }


    private void recalculate(){
        total = 0.0;

        total += getKat().getTotal();
        total += getPodrum().getTotal();
        total += getPrizemlje().getTotal();
        total += getTemelj().getTotal();

        if(krov != null)
            total += getKrov().getTotal();

        valueChanged();
    }
}
