package com.example.apporio6.crewme;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;


import com.example.apporio6.crewme.Adapter.SampleAdapter;

import com.example.apporio6.crewme.Fragments.Chat_Fragment;
import com.example.apporio6.crewme.Fragments.Home_Fragment;
import com.example.apporio6.crewme.Fragments.Maps_fragment;
import com.example.apporio6.crewme.Fragments.Settings_Fragment;
import com.example.apporio6.crewme.Fragments.Tickets_Fragment;
import com.example.apporio6.crewme.Fragments.Unlock_Fragment;
import com.example.apporio6.crewme.flingswipe.SwipeFlingAdapterView;
import com.example.apporio6.crewme.networkchecker.NetworkChecker;


import java.util.ArrayList;



public class MainActivity extends FragmentActivity {


    Spinner sp;
    Fragment fragment = null;
    TextView settingsheading;
    public  static  MainActivity mainact;
    String data[] = {"All Companies", "Air India", "Jet Airways", "Indigo"};
    ImageView home, chat, maps, tickets, unlock, settings, pbimage, searchagain, imagehide, imagehide2, imagehide3;
    LinearLayout llforsearch, llforsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        statusbar.setStatusBarColor(MainActivity.this, R.color.backgroundcolor);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = (Spinner) findViewById(R.id.spinnerbg);
        home = (ImageView) findViewById(R.id.home);
        chat = (ImageView) findViewById(R.id.chat);
        maps = (ImageView) findViewById(R.id.map);
        settingsheading = (TextView) findViewById(R.id.headingsetting);
        tickets = (ImageView) findViewById(R.id.tickets);
        unlock = (ImageView) findViewById(R.id.unlock);
        settings = (ImageView) findViewById(R.id.settings);
        llforsearch = (LinearLayout)findViewById(R.id.llforsearch);
        llforsp = (LinearLayout)findViewById(R.id.llforsp);
        mainact = MainActivity.this;
        fragment = new Home_Fragment();
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container3, fragment).commit();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
        llforsp.setVisibility(View.VISIBLE);
        llforsearch.setVisibility(View.GONE);
        settingsheading.setVisibility(View.GONE);
        home.setImageResource(R.drawable.homeactive);
        chat.setImageResource(R.drawable.chatinactive);
        maps.setImageResource(R.drawable.mapinactive);
        tickets.setImageResource(R.drawable.ticketinactive);
        unlock.setImageResource(R.drawable.unlockinactive);
        settings.setImageResource(R.drawable.settingsinactive);

        sp.setAdapter(new ArrayAdapter(MainActivity.this, R.layout.itemlayoutfordropdown,
                R.id.txtitem, data));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                home.setImageResource(R.drawable.homeactive);
                chat.setImageResource(R.drawable.chatinactive);
                maps.setImageResource(R.drawable.mapinactive);
                tickets.setImageResource(R.drawable.ticketinactive);
                unlock.setImageResource(R.drawable.unlockinactive);
                settings.setImageResource(R.drawable.settingsinactive);
                llforsp.setVisibility(View.VISIBLE);
                llforsearch.setVisibility(View.GONE);
                settingsheading.setVisibility(View.GONE);
                fragment = new Home_Fragment();
                if (fragment != null) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container3, fragment).commit();

                } else {
                    Log.e("MainActivity", "Error in creating fragment");
                }
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.homeinactive);
                chat.setImageResource(R.drawable.chatactive);
                maps.setImageResource(R.drawable.mapinactive);
                tickets.setImageResource(R.drawable.ticketinactive);
                unlock.setImageResource(R.drawable.unlockinactive);
                settings.setImageResource(R.drawable.settingsinactive);
                llforsp.setVisibility(View.GONE);
                llforsearch.setVisibility(View.VISIBLE);
                settingsheading.setVisibility(View.GONE);
                fragment = new Chat_Fragment();
                if (fragment != null) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container3, fragment).commit();

                } else {
                    Log.e("MainActivity", "Error in creating fragment");
                }
            }
        });
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.homeinactive);
                chat.setImageResource(R.drawable.chatinactive);
                maps.setImageResource(R.drawable.mapactive);
                tickets.setImageResource(R.drawable.ticketinactive);
                unlock.setImageResource(R.drawable.unlockinactive);
                settings.setImageResource(R.drawable.settingsinactive);
                llforsp.setVisibility(View.GONE);
                llforsearch.setVisibility(View.GONE);
                settingsheading.setVisibility(View.GONE);
                fragment = new Maps_fragment();
                if (fragment != null) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container3, fragment).commit();

                } else {
                    Log.e("MainActivity", "Error in creating fragment");
                }
            }
        });
        tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.homeinactive);
                chat.setImageResource(R.drawable.chatinactive);
                maps.setImageResource(R.drawable.mapinactive);
                tickets.setImageResource(R.drawable.ticketactive);
                unlock.setImageResource(R.drawable.unlockinactive);
                settings.setImageResource(R.drawable.settingsinactive);
                llforsp.setVisibility(View.GONE);
                llforsearch.setVisibility(View.GONE);
                settingsheading.setVisibility(View.GONE);
                fragment = new Tickets_Fragment();
                if (fragment != null) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container3, fragment).commit();

                } else {
                    Log.e("MainActivity", "Error in creating fragment");
                }
            }
        });
        unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.homeinactive);
                chat.setImageResource(R.drawable.chatinactive);
                maps.setImageResource(R.drawable.mapinactive);
                tickets.setImageResource(R.drawable.ticketinactive);
                unlock.setImageResource(R.drawable.unlockactive);
                settings.setImageResource(R.drawable.settingsinactive);
                llforsp.setVisibility(View.GONE);
                llforsearch.setVisibility(View.GONE);
                settingsheading.setVisibility(View.GONE);
                fragment = new Unlock_Fragment();
                if (fragment != null) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container3, fragment).commit();

                } else {
                    Log.e("MainActivity", "Error in creating fragment");
                }
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.homeinactive);
                chat.setImageResource(R.drawable.chatinactive);
                maps.setImageResource(R.drawable.mapinactive);
                tickets.setImageResource(R.drawable.ticketinactive);
                unlock.setImageResource(R.drawable.unlockinactive);
                settings.setImageResource(R.drawable.settingsactive);
                llforsp.setVisibility(View.GONE);
                llforsearch.setVisibility(View.GONE);
                settingsheading.setVisibility(View.VISIBLE);
                fragment = new Settings_Fragment();
                if (fragment != null) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container3, fragment).commit();

                } else {
                    Log.e("MainActivity", "Error in creating fragment");
                }
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}
