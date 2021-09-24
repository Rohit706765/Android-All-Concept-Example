package com.example.androidconcept.AlarmManager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.androidconcept.R;

import static android.content.Context.NOTIFICATION_SERVICE;
import static com.example.androidconcept.AlarmManager.AlarmActivity.CHANNEL1;

public class MyBrodcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, AlarmActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent1, 0);

        Notification notification = new NotificationCompat.Builder(context, CHANNEL1)
                .setContentTitle("Alarm created ")
                .setSmallIcon(R.drawable.ic_like)
                .setContentText("alarm buzz")
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager managerCompat = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        managerCompat.notify(1,notification);
    }
}
