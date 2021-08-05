package com.example.androidconcept.FirebaseConcept;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidconcept.FirebaseConcept.Model.Information;
import com.example.androidconcept.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FireBase3 extends AppCompatActivity {

    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base3);

        //TODO creating branch tree in firebase
       /* database = FirebaseDatabase.getInstance();
        for (int i = 0; i < 2; i++) {
            HashMap<String, Object> branch = new HashMap<>();
            branch.put("email","ks854545@gmail.com");
            branch.put("name","kajal");
            database.getReference().child("Information").child("Branch"+(i+1)).updateChildren(branch);
        }*/

        //TODO Fetching value from  tree in firebase
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Information"); //.child("Branch")
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren())
                {
                    Information information = snapshot1.getValue(Information.class);
                    Toast.makeText(FireBase3.this, ""+ information.getName()+" "+ information.getEmail(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}