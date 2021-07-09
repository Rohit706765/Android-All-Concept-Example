package com.example.androidconcept.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidconcept.R;
import com.example.androidconcept.Spinner.SpinnerModel.SpinnerModel;

import java.util.ArrayList;
import java.util.List;

public class SpinnerConcept extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    List<SpinnerModel> spinnerData = new ArrayList<>();

    String[] banks = {"BOB","PNB","Union","Axis","HDFC","SBI"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_spinner_concept);

        Spinner spin = findViewById(R.id.spinner);
       // ArrayAdapter<String> bankAdp = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,banks);

        spinnerData.add(new SpinnerModel(R.drawable.bg_image,"HDFC"));
        spinnerData.add(new SpinnerModel(R.drawable.bg_image,"PNB"));
        spinnerData.add(new SpinnerModel(R.drawable.bg_image,"BOB"));
        spinnerData.add(new SpinnerModel(R.drawable.bg_image,"Union"));
        spinnerData.add(new SpinnerModel(R.drawable.bg_image,"Axis"));
        spinnerData.add(new SpinnerModel(R.drawable.bg_image,"SBI"));

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(SpinnerConcept.this,spinnerData);
        spin.setAdapter(spinnerAdapter);

        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(), banks[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}