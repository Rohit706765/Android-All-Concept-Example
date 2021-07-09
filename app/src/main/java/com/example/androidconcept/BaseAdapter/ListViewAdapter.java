package com.example.androidconcept.BaseAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.androidconcept.BaseAdapter.DataModelList.ListModel;
import com.example.androidconcept.R;

import java.util.ArrayList;

public class ListViewAdapter extends AppCompatActivity {

    ArrayList<ListModel> countryData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_adapter);
        ListView listView = findViewById(R.id.listView);

        countryData.add(new ListModel(R.drawable.bg_image,"America"));
        countryData.add(new ListModel(R.drawable.bg_image,"India"));
        countryData.add(new ListModel(R.drawable.bg_image,"Pakistan"));
        countryData.add(new ListModel(R.drawable.bg_image,"Austraila"));
        countryData.add(new ListModel(R.drawable.bg_image,"Japan"));
        countryData.add(new ListModel(R.drawable.bg_image,"Norway"));

        FlagAdapterList flagAdapterList = new FlagAdapterList(ListViewAdapter.this,countryData);
        listView.setAdapter(flagAdapterList);

    }
}