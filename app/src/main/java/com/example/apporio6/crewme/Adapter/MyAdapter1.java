package com.example.apporio6.crewme.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.apporio6.crewme.Fragments.Basefragmentforphotoopen;

import java.util.ArrayList;




public class MyAdapter1 extends FragmentPagerAdapter {
    ArrayList<String> a;
    int[] f;
        int b;


    public MyAdapter1(FragmentManager fm, int position1, int[] arrayB) {
        super(fm);
        this.b =position1;
        f=arrayB;


    }



    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;

        frag= Basefragmentforphotoopen.newInstance(position, f[position]);


        return frag;
    }

    @Override
    public int getCount() {
        return f.length;
    }
}