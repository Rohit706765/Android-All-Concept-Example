package com.example.androidconcept.Services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.androidconcept.R;

public class NotificationServiceActivity extends AppCompatActivity {

    Context context;
    EditText enterMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_service);
        enterMe = findViewById(R.id.edtEnter);
        context = this;
    }

    public void startME(View view) {
        String input = enterMe.getText().toString();
        Intent intent = new Intent(context,NotificationServices.class);
        intent.putExtra("data",input);
        ContextCompat.startForegroundService(this,intent);
    }

    public void stopME(View view) {
        Intent intent = new Intent(context,NotificationServices.class);
        stopService(intent);
    }
}