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
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.Krov;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.RavniKrov;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.listener.TextValueChangeListener;

/**
 * Created by Goran on 29.5.2018..
 */

public class RavniKrovFragment extends Fragment {

   // private RavniKrov ravnikrov;

    public RavniKrovFragment(){// ravnikrov = (RavniKrov) KalkulatorIzradeKuce.getInstance().getKrov();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.ravnikrov, container, false);

        final EditText e = v.findViewById(R.id.RavniKrovPovrsina);
        e.addTextChangedListener(new TextValueChangeListener() {
            @Override
            public void textChanged(String newText) {
                KalkulatorIzradeKuce.getInstance().getKrov().setKvadratura(newText.isEmpty() ? 0 : Double.parseDouble(newText));
            }
        });

        final SeekBar sb = v.findViewById(R.id.RavniKrovVisAtBar);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ((RavniKrov) KalkulatorIzradeKuce.getInstance().getKrov()).setVisinaAtike(Double.valueOf(sb.getProgress()));
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
