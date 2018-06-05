package com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.goran.projektkalkulatorzaizgradnjukuce.R;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KalkulatorIzradeKuce;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.Temelj;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.listener.TextValueChangeListener;

/**
 * Created by Goran on 29.5.2018..
 */

public class TemeljFragment extends Fragment {

    private Temelj temelj;

    public TemeljFragment() {
        temelj = KalkulatorIzradeKuce.getInstance().getTemelj();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.temelj, container, false);

        final EditText e = v.findViewById(R.id.TemeljKvadratura);
        e.addTextChangedListener(new TextValueChangeListener() {
            @Override
            public void textChanged(String newText) {
                temelj.setKvadratura(newText.isEmpty() ? 0 : Double.parseDouble(newText));
            }
        });

        final SeekBar sb1 = v.findViewById(R.id.TemeljVisNadTemBar);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                temelj.setVisinaNadtemelja(Double.valueOf(sb1.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar sb2 = v.findViewById(R.id.TemeljNagibTerBar);
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                temelj.setNagibTerena(Double.valueOf(sb2.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        return v;
    }

}
