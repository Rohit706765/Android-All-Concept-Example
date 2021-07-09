package com.example.androidconcept.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidconcept.R;

public class MyService extends Service {

    MediaPlayer musicPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        musicPlayer = MediaPlayer.create(this, R.raw.dranger);
        musicPlayer.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        onTaskRemoved(intent); // called this when onStartCommand called
        Toast.makeText(this, "Services is started in background", Toast.LENGTH_SHORT).show();
        musicPlayer.start();
        return START_STICKY;
    }

    /**
     *  {@link #onDestroy() not use this for background activity }
     */

    @Override
    public void onDestroy() {
        super.onDestroy();
        musicPlayer.start();
        Toast.makeText(this, "Services is stoppted", Toast.LENGTH_SHORT).show();
    }

    /**
     * {@link #onTaskRemoved(Intent) help to run in background  }
     * */
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Intent restartServiceIntent = new Intent(getApplicationContext(),this.getClass());
        restartServiceIntent.setPackage(getPackageName());
        startService(restartServiceIntent); //
        super.onTaskRemoved(rootIntent);
    }
}
