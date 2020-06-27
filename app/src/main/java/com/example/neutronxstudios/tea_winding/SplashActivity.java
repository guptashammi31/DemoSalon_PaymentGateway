package com.example.neutronxstudios.tea_winding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(SPLASH_TIME_OUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                    Intent intent =new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);

                }

            }
        }).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }



}
