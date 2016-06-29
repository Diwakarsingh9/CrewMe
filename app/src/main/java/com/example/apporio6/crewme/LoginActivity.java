package com.example.apporio6.crewme;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends Activity {

    ImageView login,signup;
    TextView forgotpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        statusbar.setStatusBarColor(LoginActivity.this,R.color.statusbarcolorlogin);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login =(ImageView)findViewById(R.id.login);
        signup =(ImageView)findViewById(R.id.signup);
        forgotpass =(TextView)findViewById(R.id.frgt);
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(in);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(in);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(in);
            }
        });
    }
}
