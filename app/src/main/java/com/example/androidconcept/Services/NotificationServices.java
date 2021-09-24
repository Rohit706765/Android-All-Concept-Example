package com.example.androidconcept.Services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.androidconcept.R;

import static com.example.androidconcept.Services.AppNotification.CHANNEL_1;

public class NotificationServices extends Service {

    // it call one time
    @Override
    public void onCreate() {
        super.onCreate();
    }

    // it call every  time when notification created
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String string = intent.getStringExtra("data");
        Intent intent1 = new Intent(this,NotificationServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent1,0);

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_1)
                .setContentText(string)
                .setContentTitle("Services Running ")
                .setContentIntent(pendingIntent).setSmallIcon(R.drawable.ic_like).build();

        // dont do your heavy task here because it work on
        // main thread
        startForeground(1,notification);
        return START_NOT_STICKY;   //START_NOT_STICKY - if service not began every time
                                // START_STICKY  - it restart service ASAP (but intent is null pass)
                                // START_REDELIVER_INTENT  - it restart service ASAP (but intent is not null pass)
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
