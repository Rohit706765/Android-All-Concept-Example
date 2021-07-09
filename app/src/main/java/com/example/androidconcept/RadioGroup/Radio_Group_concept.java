package com.example.androidconcept.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidconcept.R;

public class Radio_Group_concept extends AppCompatActivity {

    Button btn_submit;
    RadioButton john , roman , akshay;
    String click;

    String[] name = {"rohit","sonal","kajal","rajan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio__group_concept);

        AutoCompleteTextView autoComplete = findViewById(R.id.txt_my_Fav);
        ArrayAdapter<String> adapter = new ArrayAdapter(Radio_Group_concept.this, R.layout.support_simple_spinner_dropdown_item,name);
        autoComplete.setAdapter(adapter);
        autoComplete.setThreshold(1);
       /* RatingBar ratingBar = findViewById(R.id.rating);

        Toast.makeText(this, "RAte "+ratingBar.getRating(), Toast.LENGTH_SHORT).show();*/
        /*btn_submit = findViewById(R.id.btn_submit);

        roman = findViewById(R.id.roman);
        john = findViewById(R.id.John);
        akshay = findViewById(R.id.Akshay);

         click = "null";*/

        /*btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roman.isChecked())
                {
                    click = roman.getText().toString();
                }
                else if(john.isChecked())
                {
                    click = john.getText().toString();
                }
                else if(akshay.isChecked())
                {
                    click = akshay.getText().toString();
                }
                else
                {
                    Log.e("Radio","wrong choice");
                }

                Toast.makeText(Radio_Group_concept.this, "Radio "+click, Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}