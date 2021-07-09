package com.example.androidconcept.BaseAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.androidconcept.MainActivity;
import com.example.androidconcept.R;

public class BaseAdapterConcept extends AppCompatActivity {

    int[] animalImg = {R.drawable.bg_image,R.drawable.bg_image,R.drawable.bg_image,R.drawable.bg_image,R.drawable.bg_image,R.drawable.bg_image,R.drawable.bg_image,R.drawable.bg_image,R.drawable.bg_image};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_concept);

        GridView gridView = findViewById(R.id.grid_animal);
        CustomAdapter customAdapter = new CustomAdapter(BaseAdapterConcept.this,animalImg);
        gridView.setAdapter(customAdapter)  ;
    }
}