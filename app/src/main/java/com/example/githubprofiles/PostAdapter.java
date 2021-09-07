package com.example.githubprofiles;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private List<ResponseDTO> postModelList;
    public PostAdapter(List<ResponseDTO> postModelList){
        this.postModelList = postModelList;
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        ResponseDTO responseDTO = postModelList.get(position);
        holder.setData(responseDTO);

    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }
}
