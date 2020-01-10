package com.example.notificationapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANNEL_1_ID ="channel1";
    public static final String CHANNEL_2_ID ="channel2";

    public static int i = 3;

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is channel 1");

            NotificationChannel channel2 = new NotificationChannel(CHANNEL_2_ID,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW);
            channel2.setDescription("This is channel 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

        }
    }
}
