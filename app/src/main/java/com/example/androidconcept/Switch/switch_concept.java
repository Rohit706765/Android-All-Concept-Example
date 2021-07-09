package com.example.androidconcept.Switch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;

import com.example.androidconcept.R;

public class switch_concept extends AppCompatActivity {

    private String TAG = "Switch_Concept";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_concept);

        Switch first_switch = findViewById(R.id.switchConcept);
        if (first_switch.isChecked())
        {
            String value = first_switch.getTextOn().toString();
            Log.e(TAG,"value is "+value);
        }
    }
}