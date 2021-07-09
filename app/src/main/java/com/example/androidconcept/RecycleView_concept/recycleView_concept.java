package com.example.androidconcept.RecycleView_concept;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.androidconcept.R;
import com.example.androidconcept.RecycleView_concept.RecycleAdapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class recycleView_concept extends AppCompatActivity {

    Context context;
    List<String> name = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_concept);

        context = this;

        name.add("Rohit");
        name.add("Kajal");
        name.add("Sonal");
        name.add("Ranjan");
        name.add("MAha");
        name.add("Jyoti");

        RecyclerView recyclerView = findViewById(R.id.nameView);
        LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,true);
        CustomAdapter adapter = new CustomAdapter(context,name);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }
}