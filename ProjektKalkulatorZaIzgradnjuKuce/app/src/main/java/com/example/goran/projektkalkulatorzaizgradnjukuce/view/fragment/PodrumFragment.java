package com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.goran.projektkalkulatorzaizgradnjukuce.R;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KalkulatorIzradeKuce;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.Podrum;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.listener.TextValueChangeListener;

/**
 * Created by Goran on 29.5.2018..
 */

public class PodrumFragment  extends Fragment{

    private Podrum podrum;

    public PodrumFragment() {
        podrum= KalkulatorIzradeKuce.getInstance().getPodrum();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.podrum, container, false);

        final EditText e = v.findViewById(R.id.PodrumKvadratura);
        e.addTextChangedListener(new TextValueChangeListener() {
            @Override
            public void textChanged(String newText) {
                podrum.setKvadratura(newText.isEmpty() ? 0 : Double.parseDouble(newText));
            }
        });

        return v;
    }
}
