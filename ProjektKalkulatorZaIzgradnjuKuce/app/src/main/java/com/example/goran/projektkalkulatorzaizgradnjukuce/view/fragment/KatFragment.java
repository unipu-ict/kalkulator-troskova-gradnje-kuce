package com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.FocusFinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.goran.projektkalkulatorzaizgradnjukuce.R;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KalkulatorIzradeKuce;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.Kat;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.listener.TextValueChangeListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class KatFragment extends Fragment {

    private Kat kat;
    public KatFragment() {
        kat = KalkulatorIzradeKuce.getInstance().getKat();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.kat, container, false);


        final EditText e = v.findViewById(R.id.KatKvadratura);
        e.addTextChangedListener(new TextValueChangeListener() {
            @Override
            public void textChanged(String newText) {
                kat.setKvadratura(newText.isEmpty() ? 0 : Double.parseDouble(newText));
            }
        });

        final SeekBar sb1 = v.findViewById(R.id.KatPregZidSeekBar);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                kat.setPregradniZidovi(Double.valueOf(sb1.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar sb2 = v.findViewById(R.id.KatDimnjakSeekBar);
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                kat.setBrojDimnjaka(Integer.valueOf(sb2.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Switch s1 = v.findViewById(R.id.KatPBSw);
        s1.setChecked(kat.getPorobeton());


        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                kat.setPorobeton(b);
            }
        });

        Switch s2 = v.findViewById(R.id.KatDrugiKatSW);
        s2.setChecked(kat.getDrugiKatIsti());



        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                kat.setDrugiKatIsti(b);
            }
        });


        return v;
    }
}
