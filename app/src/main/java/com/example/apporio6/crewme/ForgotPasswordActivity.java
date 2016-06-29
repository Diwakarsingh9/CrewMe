package com.example.apporio6.crewme;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ForgotPasswordActivity extends Activity {
    ImageView cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        statusbar.setStatusBarColor(ForgotPasswordActivity.this,R.color.statusbarcolorlogin);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        cancel =(ImageView)findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
