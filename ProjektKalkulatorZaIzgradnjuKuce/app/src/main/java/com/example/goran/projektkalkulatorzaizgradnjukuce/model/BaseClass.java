package com.example.goran.projektkalkulatorzaizgradnjukuce.model;

/**
 * Created by Goran on 29.5.2018..
 */

public abstract class BaseClass {

    private ValueChangeListener valueChangeListener;

    protected void valueChanged(){
        if(valueChangeListener != null)
            valueChangeListener.valueChanged();
    }

    public void setValueChangeListener(ValueChangeListener valueChangeListener){
        this.valueChangeListener = valueChangeListener;
    }

    public abstract Double getTotal();

}
