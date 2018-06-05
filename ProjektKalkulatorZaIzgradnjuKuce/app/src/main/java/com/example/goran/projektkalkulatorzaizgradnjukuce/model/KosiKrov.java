package com.example.goran.projektkalkulatorzaizgradnjukuce.model;

public class KosiKrov extends Krov {

    private Boolean zabatniZid = Boolean.FALSE;
    private Integer brojDimnjaka = 0;
    private Double visinaNadozida = 0.0;

    public Boolean getZabatniZid() {
        return zabatniZid;
    }

    public void setZabatniZid(Boolean zabatniZid) {
        this.zabatniZid = zabatniZid;
        valueChanged();
    }

    public Integer getBrojDimnjaka() {
        return brojDimnjaka;
    }

    public void setBrojDimnjaka(Integer brojDimnjaka) {
        this.brojDimnjaka = brojDimnjaka;
        valueChanged();
    }

    public Double getVisinaNadozida() {
        return visinaNadozida;
    }

    public void setVisinaNadozida(Double visinaNadozida) {
        this.visinaNadozida = visinaNadozida;
        valueChanged();
    }

    public Double getTotalDimnjak(){
        if (brojDimnjaka!=null)
            return (double)brojDimnjaka*360;

        return 0.0;
    }

    public Double getTotalZabatniZid(){
        if (zabatniZid!=null && zabatniZid)
                return 240.0;

        return 0.0;
    }

    public Double getTotalVisinaNadozida(){
        if (visinaNadozida!=null)
            return visinaNadozida * 3.5;

        return 0.0;
    }

    @Override
    public Double getTotal() {
        return getTotalDimnjak() + getTotalZabatniZid() + getTotalVisinaNadozida();
    }
}
