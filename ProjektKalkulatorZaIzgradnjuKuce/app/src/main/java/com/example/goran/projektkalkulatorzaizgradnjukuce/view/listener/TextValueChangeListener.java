package com.example.goran.projektkalkulatorzaizgradnjukuce.view.listener;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Goran on 29.5.2018..
 */

public abstract class TextValueChangeListener implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        textChanged(editable.toString());
    }
    public abstract void textChanged(String newText);

}
