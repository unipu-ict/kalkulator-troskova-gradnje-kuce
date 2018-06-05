package com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.goran.projektkalkulatorzaizgradnjukuce.R;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KalkulatorIzradeKuce;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KosiKrov;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.Krov;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.RavniKrov;

/**
 * Created by Goran on 29.5.2018..
 */

public class KrovFragment extends Fragment {


    private Krov krov;

    public KrovFragment() {
        krov = KalkulatorIzradeKuce.getInstance().getKrov();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.krov, container, false);

        final Switch ravniKrov = v.findViewById(R.id.KrovRavniSwitch);

        final Switch kosiKrov = v.findViewById(R.id.KrovKosiSwitch);


        if (KalkulatorIzradeKuce.getInstance().getKrov() instanceof RavniKrov)
            ravniKrov.setChecked(true);

        if (KalkulatorIzradeKuce.getInstance().getKrov() instanceof KosiKrov)
            kosiKrov.setChecked(true);

        kosiKrov.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                KalkulatorIzradeKuce.getInstance().setKrov(b ? new KosiKrov() : ravniKrov.isChecked()?new RavniKrov():null);

                if(b) {
                    ravniKrov.setChecked(false);
                }
            }
        });

        ravniKrov.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                KalkulatorIzradeKuce.getInstance().setKrov(b ? new RavniKrov()  : kosiKrov.isChecked()?new KosiKrov():null);

                if(b){
                    kosiKrov.setChecked(false);
                }
            }
        });


        return v;
    }

}
