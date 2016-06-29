package com.example.apporio6.crewme.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.apporio6.crewme.R;
import com.example.apporio6.crewme.views.ProgressWheel;

/**
 * Created by apporio6 on 27-06-2016.
 */
public class Unlock_Fragment extends Fragment {
    Context ctc;

    public static ProgressWheel pb;
    TextView descp,km,man,woman;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.unlock_fragment, container, false);
        ctc = getActivity();
        descp = (TextView) v.findViewById(R.id.descp);
        descp.setText(Html.fromHtml(""+"Increase your experience,"+"<font color='#5ED384'>" +" unlock open match "+ "</font>" +"and discover who liked your profile, don&apos;t waste your time anymore"));
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
