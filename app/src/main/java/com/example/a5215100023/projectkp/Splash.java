package com.example.a5215100023.projectkp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        getSupportActionBar().hide();

        final User user = new User(Splash.this);
        Timer timer = new Timer();

        if (user.getName()!=""){
            Intent i = new Intent(Splash.this, MenuToilet.class);
            startActivity(i);
            finish();
        } else {
            Intent i = new Intent(Splash.this, Login.class);
            startActivity(i);
            finish();
        }

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                if (user.getName()!=""){
//                    Intent i = new Intent(Splash.this, MenuToilet.class);
//                    startActivity(i);
//                    finish();
//                } else {
//                    Intent i = new Intent(Splash.this, Login.class);
//                    startActivity(i);
//                    finish();
//                }
//            }
//        },1000);
    }

}
