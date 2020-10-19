package com.example.facebookposts.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebookposts.data.PostClient;
import com.example.facebookposts.pojo.postModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<postModel>> postMutableLiveData=new MutableLiveData<>();
    public void getPosts(){
        PostClient.getInstance().getPosts().enqueue(new Callback<List<postModel>>() {
            @Override
            public void onResponse(Call<List<postModel>> call, Response<List<postModel>> response) {
                postMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<postModel>> call, Throwable t) {

            }
        });
    }
}
