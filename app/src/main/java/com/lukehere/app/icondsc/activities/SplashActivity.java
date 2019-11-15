package com.lukehere.app.icondsc.activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.lukehere.app.icondsc.R;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    public static final String FIRST_OPEN = "first_open";
    public static final String PREFERENCE_FILE = "preference_file";
    private static final int DELAY_TIME_SHORT = 1000;
    private static final int DELAY_TIME_LONG = 3000;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(getString(R.string.channel_id), name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        final SharedPreferences sharedpreferences = getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
        int firstOpen = sharedpreferences.getInt(FIRST_OPEN, 0);

        if (firstOpen == 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SplashActivity.this, IntroductionActivity.class);
                    startActivity(i);
                    finish();
                }
            }, DELAY_TIME_LONG);


        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SplashActivity.this, AuthenticationActivity.class);
                    startActivity(i);
                    finish();
                }
            }, DELAY_TIME_SHORT);
        }
    }
}
