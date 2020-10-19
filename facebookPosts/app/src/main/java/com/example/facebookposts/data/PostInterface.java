package com.example.facebookposts.data;

import com.example.facebookposts.pojo.postModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public  Call<List<postModel>> getPosts();
}
