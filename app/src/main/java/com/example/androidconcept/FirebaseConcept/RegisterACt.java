package com.example.androidconcept.FirebaseConcept;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidconcept.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterACt extends AppCompatActivity {

    EditText edt_name,edt_last;
    Button btn_register;
    String email,password;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_a_ct);

        edt_last = findViewById(R.id.edt_last);
        edt_name = findViewById(R.id.edt_name);
        btn_register = findViewById(R.id.btn_register);

        auth  = FirebaseAuth.getInstance();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edt_name.getText().toString();
                password = edt_last.getText().toString();
                
                if (email.isEmpty()|| password.isEmpty())
                {
                    Toast.makeText(RegisterACt.this, "empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    regUser(email,password);
                }
            }
        });
    }

    private void regUser(String email, String password) {

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterACt.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(RegisterACt.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RegisterACt.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}