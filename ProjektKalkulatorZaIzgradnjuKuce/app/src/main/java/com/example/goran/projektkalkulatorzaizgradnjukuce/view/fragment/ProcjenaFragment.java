package com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.goran.projektkalkulatorzaizgradnjukuce.R;



/**
 * Created by Goran on 3.6.2018..
 */

public class ProcjenaFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.kat, container, false);

        TextView t1 = v.findViewById(R.id.TotalPodrum);






        return v;
    }
}
