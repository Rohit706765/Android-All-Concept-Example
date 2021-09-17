package com.example.androidconcept.RoomDataBase.Excersize1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.androidconcept.R;

import java.util.List;

public class RoomDataBaseActivity extends AppCompatActivity {

    CourseRepository courseRepository;
    Context cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_data_base);

        cont = this;
        courseRepository = new CourseRepository(cont);
//        courseRepository.insert(new User("rohit", "singh"));

        courseRepository.getAllCourses().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(cont, ""+users.get(0).firstName, Toast.LENGTH_SHORT).show();
                        }
                    });

            }
        });
    }

}