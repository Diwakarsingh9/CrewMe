package com.example.apporio6.crewme.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.apporio6.crewme.R;
import com.example.apporio6.crewme.views.ProgressWheel;

import java.util.ArrayList;

/**
 * Created by apporio6 on 27-06-2016.
 */
public class Chat_Fragment extends Fragment {
    Context ctc;

    public static ProgressWheel pb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.chat_fragment, container, false);
        ctc = getActivity();



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