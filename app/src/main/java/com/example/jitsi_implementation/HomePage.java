package com.example.jitsi_implementation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button voice_calling = findViewById(R.id.btn_voice_calling);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button video_calling = findViewById(R.id.btn_video_calling);

        voice_calling.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this , AudioCalling.class);
            startActivity(intent);
        });

        video_calling.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this , VideoCalling.class);
            startActivity(intent);
        });

    }
}