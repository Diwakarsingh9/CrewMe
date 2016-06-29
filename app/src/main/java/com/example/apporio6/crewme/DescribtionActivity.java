package com.example.apporio6.crewme;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DescribtionActivity extends Activity {
    EditText descrb;
    TextView shw;
    LinearLayout back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        statusbar.setStatusBarColor(DescribtionActivity.this,R.color.backgroundcolor);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describtion);
        descrb = (EditText)findViewById(R.id.descr);
        shw = (TextView)findViewById(R.id.shw);
        back = (LinearLayout) findViewById(R.id.llforbck);

        descrb.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int aft)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                // this will show characters remaining
                shw.setText(500 - s.toString().length() + "/500"+" characters left");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
