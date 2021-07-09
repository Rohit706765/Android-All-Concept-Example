package com.example.androidconcept.Reterofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    // https://jsonplaceholder.typicode.com/posts
    /*
     *  /posts is relative url
     *  and https://jsonplaceholder.typicode.com is base url
    */

    //https://jsonplaceholder.typicode.com/posts

    //https://jsonplaceholder.typicode.com/comments?postId=1&_Sort=id&_order=des

    @GET("posts")
    Call<List<Post>> getlist( @Query("userId")int userId,
                              @Query("_sort")String sort,
                              @Query("_order") String order);

    @GET("posts")
    Call<List<Post>> getPost();

    // https://jsonplaceholder.typicode.com/comments?postId=1
    // use query for ?
    @GET("comments")
    Call<List<Comment>> getQueryComment(@Query("postId") int postid);

 /*
     https://jsonplaceholder.typicode.com/posts/1/comments

    @GET("posts/1/comments")
    Call<List<Comment>> getComment(); */


    @GET("posts/{postId}/comments")
    Call<List<Comment>> getComment(@Path("postId") int id_);
}
