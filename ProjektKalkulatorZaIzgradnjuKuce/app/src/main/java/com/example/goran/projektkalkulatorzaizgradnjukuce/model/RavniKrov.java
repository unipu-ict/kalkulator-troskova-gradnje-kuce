package com.example.goran.projektkalkulatorzaizgradnjukuce.model;

import com.example.goran.projektkalkulatorzaizgradnjukuce.model.Krov;

public class RavniKrov extends Krov {

    private Double visinaAtike = 0.0;

    public Double getVisinaAtike() {
        return visinaAtike;
    }

    public void setVisinaAtike(Double visinaAtike) {
        this.visinaAtike = visinaAtike;
        valueChanged();
    }

    public Double getTotalVisinaAtike(){
        if(visinaAtike != null)
            return visinaAtike * 20;

        return 0.0;
    }

    @Override
    public Double getTotal() {
        return getTotalVisinaAtike();
    }
}
