package com.example.jitsi_implementation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_screen extends Activity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler = new Handler();

        handler.postDelayed(() -> {
            Intent intent = new Intent(splash_screen.this , HomePage.class);
            startActivity(intent);
            finish();
        },3000);
    }
}













