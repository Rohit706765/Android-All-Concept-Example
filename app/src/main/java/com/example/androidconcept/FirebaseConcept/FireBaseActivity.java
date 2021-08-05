package com.example.androidconcept.FirebaseConcept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidconcept.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class FireBaseActivity extends AppCompatActivity {


    Button reg,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);

        reg = findViewById(R.id.btn_reg);
        login = findViewById(R.id.btn_login);

        //TODO create tree in firebase

        //FirebaseDatabase.getInstance().getReference().child("CamVersion").setValue("1.23.4");

        //TODO set Multiple value in firebase
//        HashMap<String,Object> map = new HashMap<>();
//        map.put("Name","rohit");
//        map.put("Email","rs706765@gmail.com");
//
//        FirebaseDatabase.getInstance().getReference().child("FirstData").updateChildren(map);

        //TODO simple registration is here

      /*  reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FireBaseActivity.this,RegisterACt.class));
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FireBaseActivity.this,LoginActivity.class));
                finish();
            }
        });*/


        // for connecting firebase go to https://firebase.google.com/
        // 1 . click on get Started
        // 2 . Create your project in firebase Website
        // 3 . in Android go to Tools->Firebase
        // 4 . Firebase panel open and Connect to the firebase
        // 5 .in Firebase panel Click "Real time database to your app"


        //TODO write in fireBase data

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//        myRef.setValue("Hello, World!");

        //TODO read in fireBase Data

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Toast.makeText(FireBaseActivity.this, "value "+value, Toast.LENGTH_SHORT).show();
//                Log.d("TAG", "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("TAG", "Failed to read value.", error.toException());
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null)
        {
            startActivity(new Intent(FireBaseActivity.this,Firebase2Activity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }
    }
}