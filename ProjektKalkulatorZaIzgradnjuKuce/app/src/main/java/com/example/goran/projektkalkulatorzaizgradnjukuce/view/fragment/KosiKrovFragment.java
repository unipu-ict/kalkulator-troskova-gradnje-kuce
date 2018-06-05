package com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;

import com.example.goran.projektkalkulatorzaizgradnjukuce.R;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KalkulatorIzradeKuce;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KosiKrov;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.Krov;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.listener.TextValueChangeListener;


/**
 * Created by Goran on 29.5.2018..
 */

public class KosiKrovFragment extends Fragment {

 //   private KosiKrov kosikrov;

    public KosiKrovFragment(){
    //    kosikrov = (KosiKrov) KalkulatorIzradeKuce.getInstance().getKrov();
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.kosikrov, container, false);

        final EditText e = v.findViewById(R.id.KosiKrovKvadratura);
        e.addTextChangedListener(new TextValueChangeListener() {
            @Override
            public void textChanged(String newText) {
                KalkulatorIzradeKuce.getInstance().getKrov().setKvadratura(newText.isEmpty() ? 0 : Double.parseDouble(newText));
            }
        });

        final SeekBar sb1 = v.findViewById(R.id.KosiKrovVisNZidBar);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ((KosiKrov) KalkulatorIzradeKuce.getInstance().getKrov()).setVisinaNadozida(Double.valueOf(sb1.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar sb2 = v.findViewById(R.id.KosiKrovDimnjaciBar);
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ((KosiKrov) KalkulatorIzradeKuce.getInstance().getKrov()).setBrojDimnjaka(Integer.valueOf(sb2.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        Switch s = v.findViewById(R.id.KosiKrovZZSw);
        s.setChecked( ((KosiKrov) KalkulatorIzradeKuce.getInstance().getKrov()).getZabatniZid());

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ((KosiKrov) KalkulatorIzradeKuce.getInstance().getKrov()).setZabatniZid(b);
            }
        });


        return v;
    }


}
