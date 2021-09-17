package com.example.androidconcept.Reterofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidconcept.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    TextView tv_result;
    JsonPlaceHolderServices jsonPlaceHolderServices;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        tv_result = findViewById(R.id.tv_text);

      /*  retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/

//        jsonPlaceHolderServices = retrofit.create(JsonPlaceHolderServices.class);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.open-elevation.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderServices = retrofit.create(JsonPlaceHolderServices.class);
        String test = 10.0+","+10.0;
        Call<LocationModel> locationModelCall = jsonPlaceHolderServices.getLocation(test);
       locationModelCall.enqueue(new Callback<LocationModel>() {
           @Override
           public void onResponse(Call<LocationModel> call, Response<LocationModel> response) {
               if (response.isSuccessful())
               {
                   LocationModel models = response.body();
                   Log.e("tah",response.code()+"code "+" "+models.getLatitude());
               }
               Log.v("Error code 400",response.errorBody().toString());
           }

           @Override
           public void onFailure(Call<LocationModel> call, Throwable t) {
               Toast.makeText(RetrofitActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
        //        deletePost();
//        putPost();
//        patchPost();
//        createPost();
//        getComment();
//        getPost();
    }

    private void deletePost() {
        Call<Void> postCall = jsonPlaceHolderServices.deletePost(5);
        postCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    tv_result.setText("Code : " + response.code());
                    return;
                }
                tv_result.setText("Code : " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void patchPost() {
        Post post = new Post(15, null, "rohit");
        Call<Post> user = jsonPlaceHolderServices.patchPost(5, post);
        user.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    tv_result.setText("Code : " + response.code());
                    return;
                }
                StringBuilder data = new StringBuilder();
                Post post1 = response.body();

                data.append("User id :" + post1.getUserID() + "\n");
                data.append(" id :" + post1.getId() + "\n");
                data.append(" Title :" + post1.getTitle() + "\n");
                data.append(" Body " + post1.getBody() + "\n");

                tv_result.setText(data.toString());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void putPost() {
        Post post = new Post(15, "null", "rohit");
        Call<Post> user = jsonPlaceHolderServices.putPost(5, post);
        user.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    tv_result.setText("Code : " + response.code());
                    return;
                }
                StringBuilder data = new StringBuilder();
                Post post1 = response.body();

                data.append("User id :" + post1.getUserID() + "\n");
                data.append(" id :" + post1.getId() + "\n");
                data.append(" Title :" + post1.getTitle() + "\n");
                data.append(" Body " + post1.getBody() + "\n");

                tv_result.setText(data.toString());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }

    private void createPost() {
        Post post = new Post(1, "New User", "rohit");
        Call<Post> user = jsonPlaceHolderServices.createPost(post);
        user.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    tv_result.setText("Code : " + response.code());
                    return;
                }
                StringBuilder data = new StringBuilder();
                Post post1 = response.body();

                data.append("User id :" + post1.getUserID() + "\n");
                data.append(" id :" + post1.getId() + "\n");
                data.append(" Title :" + post1.getTitle() + "\n");
                data.append(" Body " + post1.getBody() + "\n");

                tv_result.setText(data.toString());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void getComment() {
        Call<List<Comment>> call = jsonPlaceHolderServices.getComment(2);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if (!response.isSuccessful()) {
                    tv_result.setText("Code : " + response.code());
                    return;
                }
                StringBuilder data = new StringBuilder();
                List<Comment> comments = response.body();
                for (Comment comment : comments) {
                    data.append("Post id :" + comment.getPostID() + "\n");
                    data.append(" id :" + comment.getId() + "\n");
                    data.append(" Name :" + comment.getText() + "\n");
                    data.append(" Email :" + comment.getEmail() + "\n");
                    data.append(" Comment :" + comment.getComment() + "\n");

                    tv_result.setText(data.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });

    }

    private void getPost() {

        Call<List<Post>> call = jsonPlaceHolderServices.getPost();

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