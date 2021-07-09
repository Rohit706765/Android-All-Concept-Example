package com.example.androidconcept.ProgressBar__ProgressDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidconcept.R;

public class Progress_Dialog_Concept extends AppCompatActivity {

    int progress = 0;
    Context context;
    ProgressDialog horizontalProgress ,spinner_Progress_Dialog;
    Button btn_circular_dialog,btn_horizontal_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress__dialog__concept);
        context = this;

        btn_circular_dialog = findViewById(R.id.btn_circular_dialog);
        btn_horizontal_dialog = findViewById(R.id.btn_horizontal_dialog);


        btn_circular_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 spinner_Progress_Dialog = new ProgressDialog(context);
                spinner_Progress_Dialog.setMessage("Please Wait");
                spinner_Progress_Dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                spinner_Progress_Dialog.show();
                spinner_Progress_Dialog.setCancelable(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        spinner_Progress_Dialog.dismiss();
                    }
                }).start();
            }
        });


        btn_horizontal_dialog.setOnClickListener(new View.OnClickListener() {

            final Handler handle = new Handler() {
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    horizontalProgress.incrementProgressBy(2); // Incremented By Value 2
                }
            };

            @Override
            public void onClick(View v) {
                 horizontalProgress = new ProgressDialog(context);
                horizontalProgress.setMessage("Please Wait");
                horizontalProgress.setMax(100);
                horizontalProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                horizontalProgress.setCancelable(false);
                horizontalProgress.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (horizontalProgress.getProgress()<=horizontalProgress.getMax())
                            {
                                Thread.sleep(200);
                                handle.sendMessage(handle.obtainMessage());

                                if (horizontalProgress.getMax() == horizontalProgress.getProgress())
                                {
                                    horizontalProgress.dismiss();
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            Log.e("error",e.getMessage());
                        }

                    }
                }).start();

            }
        });
    }

}