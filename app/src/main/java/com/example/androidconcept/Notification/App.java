package com.example.androidconcept.Notification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_1_ID ="rohit";
    public static final String CHANNEL_2_ID ="sonal";
    @Override
    public void onCreate() {
        super.onCreate();
        createMyNotification();
    }

    private void createMyNotification() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID,"channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("this is channel 1");

            NotificationChannel channel2 = new NotificationChannel(CHANNEL_2_ID,"channel 2",NotificationManager.IMPORTANCE_HIGH);
            channel2.setDescription("this is channel2");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);
            notificationManager.createNotificationChannel(channel2);
        }
    }
}
