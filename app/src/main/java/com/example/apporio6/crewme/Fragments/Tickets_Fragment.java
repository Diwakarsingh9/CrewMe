package com.example.apporio6.crewme.Fragments;

import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apporio6.crewme.Adapter.Ticketadapter;
import com.example.apporio6.crewme.MainActivity;
import com.example.apporio6.crewme.R;
import com.example.apporio6.crewme.views.ProgressWheel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by apporio6 on 27-06-2016.
 */
public class Tickets_Fragment extends Fragment implements TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener {
    Context ctc;
    private int myear;
    private int mmonth;
    private int mday;
    String date;
    public static ProgressWheel pb;
    TextView mile,km,man,woman,datetimetxt;
    ListView lv;
    FrameLayout datetime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.tickets_fragment, container, false);
        ctc = getActivity();
        lv= (ListView)v.findViewById(R.id.listView);
        datetimetxt= (TextView)v.findViewById(R.id.date);
        datetime= (FrameLayout)v.findViewById(R.id.llfordatetime);
        lv.setAdapter(new Ticketadapter(ctc));

        datetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                       Tickets_Fragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)

                );
                Calendar c = Calendar.getInstance();
                dpd.setMinDate(c);
                dpd.setAccentColor(Color.parseColor("#F55B47"));

                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        return v;
    }
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        final Calendar c = Calendar.getInstance();
        myear = c.get(Calendar.YEAR);
        mmonth = c.get(Calendar.MONTH)+1;
        mday = c.get(Calendar.DAY_OF_MONTH);



        date = "Date - " + dayOfMonth + "/" + (++monthOfYear) + "/" + year;

        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(
                Tickets_Fragment.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),false

        );

        tpd.setAccentColor(Color.parseColor("#F55B47"));

        tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                Log.d("TimePicker", "Dialog was cancelled");
            }
        });
        tpd.show(getFragmentManager(), "Timepickerdialog");
        //ridelater.setText(date);
    }
    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        String hourString = hourOfDay < 10 ? "0"+hourOfDay : ""+hourOfDay;
        String minuteString = minute < 10 ? "0"+minute : ""+minute;
        String time = " Time - "+hourString+" : "+minuteString;


        datetimetxt.setText(date + " at " + time);
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
