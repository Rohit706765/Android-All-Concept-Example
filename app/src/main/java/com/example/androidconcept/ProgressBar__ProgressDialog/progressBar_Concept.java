package com.example.androidconcept.ProgressBar__ProgressDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.androidconcept.R;

public class progressBar_Concept extends AppCompatActivity {

    ProgressBar circular_progress, horizontal_progress;
    Button btn_show_Progress;
    int progressValue = 0;
    String TAG = "progressBar_concept";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner__concept);

        circular_progress = findViewById(R.id.circular_spinner);
        horizontal_progress = findViewById(R.id.horizontal_spinner);
        btn_show_Progress  = findViewById(R.id.btn_show_Progress);

        btn_show_Progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circular_progress.setVisibility(View.VISIBLE);
                horizontal_progress.setVisibility(View.VISIBLE);
                setProgressValue(progressValue);
            }
        });
    }
    public void setProgressValue(int progress)
    {
        horizontal_progress.setProgress(progress);
        Thread thread  = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    Log.e(TAG,e.getMessage());
                }
                setProgressValue(progress+10);
            }
        });
        thread.start();
    }
}