package com.example.apporio6.crewme;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.apporio6.crewme.Adapter.MyAdapter1;
import com.google.android.gms.vision.text.Line;

import me.relex.circleindicator.CircleIndicator;

public class SpecificProfileActivity extends FragmentActivity {
    public  static FragmentManager fragmentManager;
    ViewPager pager;
    LinearLayout back;
    int imagess[]={R.drawable.man,R.drawable.woman,R.drawable.man,R.drawable.woman};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        statusbar.setStatusBarColor(SpecificProfileActivity.this, R.color.backgroundcolor);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_profile);
        pager = (ViewPager) findViewById(R.id.pager);
        back = (LinearLayout) findViewById(R.id.llforbck);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        fragmentManager=getSupportFragmentManager();
        pager.setAdapter(new MyAdapter1(getSupportFragmentManager(), 0, imagess));
        indicator.setViewPager(pager);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
