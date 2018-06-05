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
import android.widget.SeekBar;
import android.widget.Switch;

import com.example.goran.projektkalkulatorzaizgradnjukuce.R;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KalkulatorIzradeKuce;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.Prizemlje;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.listener.TextValueChangeListener;


/**
 * Created by Goran on 29.5.2018..
 */

public class PrizemljeFragment extends Fragment{

    private Prizemlje prizemlje;



    public PrizemljeFragment() {
        prizemlje = KalkulatorIzradeKuce.getInstance().getPrizemlje();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.prizemlje, container, false);

        //final EditText e = v.findViewById(R.id.PrizemljeKvadratura);
        //e.setText(prizemlje.getKvadratura().toString());

        final EditText e = v.findViewById(R.id.PrizemljeKvadratura);
        e.addTextChangedListener(new TextValueChangeListener() {
            @Override
            public void textChanged(String newText) {
                prizemlje.setKvadratura(newText.isEmpty() ? 0 : Double.parseDouble(newText));
            }
        });

        final SeekBar sb1 = v.findViewById(R.id.PrizemljePZidScroll);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                prizemlje.setPregradniZidovi(Double.valueOf(sb1.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar sb2 = v.findViewById(R.id.PrizemljeDimnjakScroll);
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                prizemlje.setBrojDimnjaka(Integer.valueOf(sb2.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Switch s = v.findViewById(R.id.PrizemljePBSw);
        s.setChecked(prizemlje.getPorobeton());

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                prizemlje.setPorobeton(b);
            }
        });


        return v;
    }

}
