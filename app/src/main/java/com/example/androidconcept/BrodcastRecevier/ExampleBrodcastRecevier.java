package com.example.androidconcept.BrodcastRecevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBrodcastRecevier extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
    /*    if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction()))
        {
            Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show();
        }
        else*/ if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()) )
        {
            Toast.makeText(context, "Connectvity changed ", Toast.LENGTH_SHORT).show();
        }
    }
}
