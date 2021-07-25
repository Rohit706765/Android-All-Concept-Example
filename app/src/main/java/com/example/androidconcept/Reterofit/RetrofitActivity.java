package com.example.androidconcept.Reterofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidconcept.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    TextView tv_result;
    JsonPlaceHolder jsonPlaceHolder;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        tv_result = findViewById(R.id.tv_text);

         retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

        getComment();
//        getPost();
    }
    private void getComment()
    {
        Call<List<Comment>> call = jsonPlaceHolder.getComment(2);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if (!response.isSuccessful())
                {
                    tv_result.setText("Code : "+response.code());
                    return;
                }
                StringBuilder data = new StringBuilder();
                List<Comment> comments = response.body();
                for (Comment comment : comments)
                {
                    data.append("Post id :"+comment.getPostID()+"\n");
                    data.append(" id :"+comment.getId()+"\n");
                    data.append(" Name :"+comment.getText()+"\n");
                    data.append(" Email :"+comment.getEmail()+"\n");
                    data.append(" Comment :"+comment.getComment()+"\n");

                    tv_result.setText(data.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });

    }

    private void getPost()
    {

        Call<List<Post>> call = jsonPlaceHolder.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful())  // check the response (! 404 ) between 200 ,300
                {
                    tv_result.setText("code :" + response.code());
                    return;
                }
                StringBuilder content = new StringBuilder();
                List<Post> posts = response.body();

                for (Post post : posts) {
                    content.append("ID : = " + post.getId() + "\n");
                    content.append("User ID : = " + post.getUserID() + "\n");
                    content.append("Title : = " + post.getTitle() + "\n");
                    content.append("Body : = " + post.getBody() + "\n");
                    tv_result.setText(content.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }
}