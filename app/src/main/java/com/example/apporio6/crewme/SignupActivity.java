package com.example.apporio6.crewme;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SignupActivity extends Activity {
    ImageView cancel;
    ImageView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        statusbar.setStatusBarColor(SignupActivity.this,R.color.statusbarcolorlogin);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        cancel =(ImageView)findViewById(R.id.cancel);
        signup =(ImageView)findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(in);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
    }
}
