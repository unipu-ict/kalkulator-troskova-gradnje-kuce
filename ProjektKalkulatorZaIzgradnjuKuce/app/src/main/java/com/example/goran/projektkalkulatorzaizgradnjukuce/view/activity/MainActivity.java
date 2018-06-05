package com.example.goran.projektkalkulatorzaizgradnjukuce.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.math.MathUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.goran.projektkalkulatorzaizgradnjukuce.R;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KalkulatorIzradeKuce;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.KosiKrov;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.RavniKrov;
import com.example.goran.projektkalkulatorzaizgradnjukuce.model.ValueChangeListener;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment.KatFragment;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment.KosiKrovFragment;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment.KrovFragment;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment.PodrumDodaciFragment;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment.PodrumFragment;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment.PrizemljeFragment;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment.ProcjenaFragment;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment.RavniKrovFragment;
import com.example.goran.projektkalkulatorzaizgradnjukuce.view.fragment.TemeljFragment;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int fragmentIndex = 0;
    private List<Fragment> fragments = Arrays.asList(
            new PodrumFragment(),
            new PodrumDodaciFragment(),
            new TemeljFragment(),
            new PrizemljeFragment(),
            new KatFragment(),
            new KrovFragment(),
            new RavniKrovFragment(),
            new KosiKrovFragment());
           // new ProcjenaFragment());
    private int kosiKrovIndex = 7;
    private int ravniKrovIndex = 6;

    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentIndex = 0;
        changeFragment(0);
        total = findViewById(R.id.total_iznos);

        total.setText(KalkulatorIzradeKuce.getInstance().getTotal() + " EUR");

        KalkulatorIzradeKuce.getInstance().setValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChanged() {
                total.setText(KalkulatorIzradeKuce.getInstance().getTotal() + " EUR");
            }
        });
    }

// ova metoda je namještena da radi #noTouching
    private void changeFragment(int next) {
        next = MathUtils.clamp(next, 0, fragments.size() - 1);

        boolean proceed = true;

        if (next == ravniKrovIndex) {
            proceed = (KalkulatorIzradeKuce.getInstance().getKrov() instanceof RavniKrov);
            if(!proceed){
                if(fragmentIndex<next)next++;
                else next--;
            }

        }

        if (next == kosiKrovIndex) {
            proceed = (KalkulatorIzradeKuce.getInstance().getKrov() instanceof KosiKrov);
            if(proceed){
                if(next<fragmentIndex)next-=2;
            }
        }
        if(!proceed && next < fragmentIndex) proceed = true;

        if (proceed) {
            fragmentIndex = next;
            setFragment(fragments.get(fragmentIndex));
        }


    }

    private void setFragment(Fragment f) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, f);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    public void previous(View view) {

        changeFragment(fragmentIndex-1);
    }

    public void next(View view) {
        changeFragment(fragmentIndex + 1);

    }
}





