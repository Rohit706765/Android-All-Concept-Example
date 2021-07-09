package com.example.androidconcept.Services;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.androidconcept.R;

public class MainActivity extends AppCompatActivity {

    Context context;
    String msg = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        context = this;
        Log.d(msg,"the OnCreate() method ");
    }
    /**
     * {@link MyService is started and after onStartCommand called }
     **/
    public void startService(View v)
    {
        if (isServicesRunning(MyService.class))
        {
            stopService(new Intent(MainActivity.this,MyService.class));
        }
        else
        {
            startService(new Intent(context,MyService.class));
        }
    }
    // Method to stop the service
    public void stopService(View v)
    {
        stopService(new Intent(MainActivity.this,MyService.class));
    }
    private boolean isServicesRunning(Class<?> myService)
    {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (myService.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}