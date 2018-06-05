package com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.example.goran.projektkalkulatorzaizgradnjukuce.R;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KalkulatorIzradeKuce;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.Podrum;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.listener.TextValueChangeListener;

/**
 * Created by Goran on 29.5.2018..
 */

public class PodrumDodaciFragment extends Fragment {

    private Podrum podrumdodaci;

    public PodrumDodaciFragment() {
        podrumdodaci = KalkulatorIzradeKuce.getInstance().getPodrum();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.podrumdodaci, container, false);

        final EditText e1 = v.findViewById(R.id.PodrumDodDužina);
        e1.addTextChangedListener(new TextValueChangeListener() {
            @Override
            public void textChanged(String newText) {

                podrumdodaci.setDuzina(newText.isEmpty() ? 0 : Double.parseDouble(newText));

            }
        });

        final EditText e2 = v.findViewById(R.id.PodrumDodŠirina);
        e2.addTextChangedListener(new TextValueChangeListener() {
            @Override
            public void textChanged(String newText) {
                podrumdodaci.setSirina(newText.isEmpty() ? 0 : Double.parseDouble(newText));
            }
        });

        final EditText e3 = v.findViewById(R.id.PodrumDodDubina);
        e3.addTextChangedListener(new TextValueChangeListener() {
            @Override
            public void textChanged(String newText) {
                podrumdodaci.setDubinaIskopa(newText.isEmpty() ? 0 : Double.parseDouble(newText));
            }
        });


        Switch s1 = v.findViewById(R.id.PodrumDodDrenSw);
        s1.setChecked(podrumdodaci.getDrenaza());

        Switch s2 = v.findViewById(R.id.PodrumDodIskSw);
        s2.setChecked(podrumdodaci.getIskopPodruma());

        Switch s3 = v.findViewById((R.id.PodrumDodHidrSw));
        s3.setChecked(podrumdodaci.getHidroizolacija());




        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                podrumdodaci.setDrenaza(b);
            }
        });


        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                podrumdodaci.setIskopPodruma(b);
            }
        });


        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                podrumdodaci.setHidroizolacija(b);
            }
        });


        return v;
    }

}
