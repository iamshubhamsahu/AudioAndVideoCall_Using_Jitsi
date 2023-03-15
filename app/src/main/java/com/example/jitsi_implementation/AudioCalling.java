package com.example.jitsi_implementation;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AudioCalling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button shareLink = findViewById(R.id.shareLink);

        shareLink.setOnClickListener(v -> {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"My Application Name");
                String shareMessage = "Let me recommend you this application\n\n";
                shareMessage = shareMessage +"https://meet.jit.si/";
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                startActivity(Intent.createChooser(shareIntent,"choose One"));

            } catch (Exception e) {
                e.toString();
            }


        });
    }

    public void onButtonClick(View v) {
        @SuppressLint("WrongViewCast")
        EditText editText = findViewById(R.id.edt_roomName);
        String text = editText.getText().toString();
        if (text.length() > 0) {
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setRoom(text).setConfigOverride("requireDisplayName", true)
                    .setConfigOverride("requireInviteOthers", false)
                    .setFeatureFlag("enableUserRolesBasedOnToken.enable", false)
                    .setFeatureFlag("welcome.enabled", false)
                    .setFeatureFlag("invite.enabled", false)// <-- add this line
                    .setFeatureFlag("add-people.enabled", true)// <-- add this line
                    .setFeatureFlag("invite.enabled", false)
                    .setFeatureFlag("calendar.enabled", false)
                    .setFeatureFlag("fullscreen.enabled", false)
                    .setFeatureFlag("call-integration.enabled", false)
                    .setFeatureFlag("chat.enabled", false)
                    .setFeatureFlag("close-captions.enabled", false)
                    .setFeatureFlag("help.enabled", false)
                    .setFeatureFlag("raise-hand.enabled", false)
                    .setFeatureFlag("recording.enabled", false)
                    .setFeatureFlag("settings.enabled", false)
                    .setFeatureFlag("overflow-menu.enabled", false)
                    .setFeatureFlag("toggle-camera.enabled", false)
                    .setFeatureFlag("toggle-mic.enabled", false)
                    .setFeatureFlag("hangup.enabled", true)
                    .setFeatureFlag("prepackage.enabled", false)
                    .setFeatureFlag("toolbox.alwaysVisible", false)
                    .setFeatureFlag("meeting-name.enabled", false)
                    .setFeatureFlag("security-options.enabled", false)
                    .setFeatureFlag("share.enabled", false)

                    .setFeatureFlag("microphone.enabled", false)
                    .setFeatureFlag("camera.enabled", false)
                    .setFeatureFlag("closed-captions.enabled", false)
                    .setFeatureFlag("desktop.enabled", false)
                    .setFeatureFlag("fullscreen.enabled", false)
                    .setFeatureFlag("startWithVideoMuted.enabled", false)

                    .setAudioMuted(false)
                    .setVideoMuted(true)
                    .setAudioOnly(true)
                    .setServerURL(buildUrl())
                    .build();
            JitsiMeetActivity.launch(this, options);
        }
    }

    private URL buildUrl() {

        try {
            return new URL("https://meet.jit.si");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}