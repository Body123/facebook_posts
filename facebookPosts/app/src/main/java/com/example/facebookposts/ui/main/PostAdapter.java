package com.example.facebookposts.ui.main;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookposts.R;
import com.example.facebookposts.pojo.postModel;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolderAdapter> {
    private ArrayList<postModel> List = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter holder, int position) {
        holder.titleTV.setText(List.get(position).getTitle());
        holder.userTV.setText(List.get(position).getId()+"");
        holder.titleTV.setText(List.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public void setList(ArrayList<postModel> List){
        this.List=List;
        notifyDataSetChanged();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {
        TextView titleTV,userTV,bodyTV;
        public ViewHolderAdapter(@NonNull View itemView) {
            super(itemView);
            titleTV=itemView.findViewById(R.id.titleTV);
            userTV=itemView.findViewById(R.id.userIDTV);
            titleTV=itemView.findViewById(R.id.bodyTV);
        }
    }




}

