package com.example.apporio6.crewme.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.apporio6.crewme.CountryActivity;
import com.example.apporio6.crewme.DescribtionActivity;
import com.example.apporio6.crewme.R;
import com.example.apporio6.crewme.views.ProgressWheel;

/**
 * Created by apporio6 on 27-06-2016.
 */
public class Settings_Fragment extends Fragment {
    Context ctc;

    public static ProgressWheel pb;
    public static  TextView mile,km,man,woman,countrytext;
    public static LinearLayout descp,country;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.settings_fragment, container, false);
        ctc = getActivity();
        mile = (TextView)v.findViewById(R.id.mile);
        km = (TextView)v.findViewById(R.id.km);
        man = (TextView)v.findViewById(R.id.man);
        woman = (TextView)v.findViewById(R.id.women);
        countrytext = (TextView)v.findViewById(R.id.cntrytxt);
        descp = (LinearLayout)v.findViewById(R.id.llfordescp);
        country = (LinearLayout)v.findViewById(R.id.llforcountry);
        final TextView tickHeight = (TextView)v. findViewById(R.id.tickHeight);

        SeekBar tickHeightSeek = (SeekBar)v. findViewById(R.id.tickHeightSeek);

        tickHeightSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar tickHeightSeek, int progress, boolean fromUser) {
                //rangebar.setTickHeight(progress);
                tickHeight.setText("" + progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        descp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(getActivity(), DescribtionActivity.class);
                startActivity(In);
            }
        });
        country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(getActivity(), CountryActivity.class);
                startActivity(In);
            }
        });
        mile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mile.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
                km.setBackgroundColor(getResources().getColor(R.color.white));
                mile.setTextColor(getResources().getColor(R.color.white));
                km.setTextColor(getResources().getColor(R.color.backgroundcolor));
            }
        });
        km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                km.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
                mile.setBackgroundColor(getResources().getColor(R.color.white));
                km.setTextColor(getResources().getColor(R.color.white));
                mile.setTextColor(getResources().getColor(R.color.backgroundcolor));
            }
        });
        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                man.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
                woman.setBackgroundColor(getResources().getColor(R.color.white));
                man.setTextColor(getResources().getColor(R.color.white));
                woman.setTextColor(getResources().getColor(R.color.backgroundcolor));
            }
        });
        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                woman.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
                man.setBackgroundColor(getResources().getColor(R.color.white));
                woman.setTextColor(getResources().getColor(R.color.white));
                man.setTextColor(getResources().getColor(R.color.backgroundcolor));
            }
        });
        return v;
    }


    @Override
    public void onResume() {

        super.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }
}