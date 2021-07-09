package com.example.androidconcept.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidconcept.Fragment.leftFragment;
import com.example.androidconcept.R;

public class FrameLayout extends AppCompatActivity {

    TextView first,second,third,four;
    View v_leftTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        android.widget.FrameLayout frame = (android.widget.FrameLayout) findViewById(R.id.frame);

        first = findViewById(R.id.txt_first);
        second = findViewById(R.id.txt_second);
        third = findViewById(R.id.txt_third);
        four = findViewById(R.id.txt_four);


        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new leftFragment());
            }
        });

       /* frame.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        int width = frame.getMeasuredWidth();
        int height = frame.getMeasuredHeight();

        Toast.makeText(getApplicationContext(),"width="+width+"  height="+height, Toast.LENGTH_SHORT).show();
       */
    }
    private void loadFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
    }
}