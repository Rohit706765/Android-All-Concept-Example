package com.example.androidconcept.FirebaseConcept;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidconcept.FirebaseConcept.Model.EmployeeInfo;
import com.example.androidconcept.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Firebase2Activity extends AppCompatActivity {

    private EditText employeeNameEdt, employeePhoneEdt, employeeAddressEdt;
    private Button sendDatabtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    EmployeeInfo employeeInfo;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase2);

        listView  = findViewById(R.id.listView);
        List<String> stringList = new ArrayList<>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(Firebase2Activity.this,R.layout.list_item,R.id.txt_name,stringList);
        listView.setAdapter(arrayAdapter);

        //TODO getting data from Firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("EmployeeInfo").child("Name");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                stringList.clear();
                for (DataSnapshot dataSnapshot :snapshot.getChildren())
                {
                    stringList.add(dataSnapshot.getValue().toString());
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        employeeNameEdt = findViewById(R.id.idEdtEmployeeName);
        employeePhoneEdt = findViewById(R.id.idEdtEmployeePhoneNumber);
        employeeAddressEdt = findViewById(R.id.idEdtEmployeeAddress);

        employeeInfo = new EmployeeInfo();
        firebaseDatabase  = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("EmployeeInfo");
        sendDatabtn = findViewById(R.id.idBtnSendData);
        sendDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = employeeNameEdt.getText().toString();
                String phone = employeePhoneEdt.getText().toString();
                String address = employeeAddressEdt.getText().toString();

                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(address)) {
                    Toast.makeText(Firebase2Activity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {

//                    addDatatoFirebase(name, phone, address);
                    employeeInfo.setEmployeeName(name);
                    employeeInfo.setEmployeeContactNumber(phone);
                    employeeInfo.setEmployeeAddress(address);

//                    reference.child("Name").push().setValue(employeeInfo);
                    FirebaseDatabase.getInstance().getReference().child("EmployeeInfo").child("Name").push().setValue(employeeInfo);

                }
            }
        });
    }

    private void addDatatoFirebase(String name, String phone, String address) {
        employeeInfo.setEmployeeName(name);
        employeeInfo.setEmployeeContactNumber(phone);
        employeeInfo.setEmployeeAddress(address);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                reference.child("Name").push().setValue(employeeInfo);
                //TODO store only single data in firebase child
//                reference.setValue(employeeInfo);
                Toast.makeText(Firebase2Activity.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Firebase2Activity.this, "data not added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}