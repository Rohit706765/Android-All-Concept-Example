package com.example.androidconcept.AlarmManager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.androidconcept.R;

import static com.example.androidconcept.AlarmManager.AlarmActivity.CHANNEL1;

public class AlarmService  extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent1 = new Intent(this, AlarmActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent1, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL1)
                .setContentTitle("Alarm created ")
                .setSmallIcon(R.drawable.ic_like)
                .setContentText("alarm buzz")
                .setContentIntent(pendingIntent)
                .build();


        startForeground(1,notification);
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
