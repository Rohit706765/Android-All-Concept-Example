package com.example.androidconcept.Services;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class AppNotification extends Application {

    public static final String CHANNEL_1 = "notification1";
    @Override
    public void onCreate() {
        super.onCreate();
        createNotification();
    }
    public void createNotification()
    {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(CHANNEL_1,"Service noti"
            , NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
