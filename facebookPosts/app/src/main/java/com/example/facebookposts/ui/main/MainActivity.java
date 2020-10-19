package com.example.facebookposts.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebookposts.R;
import com.example.facebookposts.pojo.postModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel= new ViewModelProvider(this).get(PostViewModel.class);

        postViewModel.getPosts();
        RecyclerView recyclerView=findViewById(R.id.recycler);
        final PostAdapter adapter=new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        postViewModel.postMutableLiveData.observe(this, new Observer<List<postModel>>() {
            @Override
            public void onChanged(List<postModel> postModels) {
                adapter.setList((ArrayList<postModel>) postModels);
            }
        });
    }
}
