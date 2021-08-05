package com.example.androidconcept.FirebaseConcept;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {
    EditText edt_name,edt_last;
    Button btn_login_now;
    FirebaseAuth auth;

    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        edt_last = findViewById(R.id.edt_last);
        edt_name = findViewById(R.id.edt_name);
        btn_login_now = findViewById(R.id.btn_login_now);
        btn_login_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edt_name.getText().toString();
                password = edt_last.getText().toString();

                if (email.isEmpty()|| password.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loging(email,password);
                }
            }
        });
    }

    private void loging(String email, String password) {

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(LoginActivity.this, "Success Login", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,Firebase2Activity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Failed Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}