package com.example.androidconcept.RoomDataBase.Excersize2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.androidconcept.R;
import com.example.androidconcept.RoomDataBase.Excersize1.User;

import java.util.List;

public class RoomDataBaseActivity2 extends AppCompatActivity {

    int i = 0;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_data_base2);
        context = this;
        DataBaseOperation baseOperation = new DataBaseOperation(context);

        baseOperation.insert(new Book("You can win", "450"));
        baseOperation.insert(new Book("Time is money", "450"));
        baseOperation.insert(new Book("Habbit build", "450"));

        baseOperation.getAllBook().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> users) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RoomDataBaseActivity2.this, "" + users.get(0).getName(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}