package com.example.githubprofiles;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvName;
    private TextView mTvLogin;
    private ImageView mTvImage;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvImage = itemView.findViewById(R.id.ivProfile);
        mTvName = itemView.findViewById(R.id.tvName);
        mTvLogin = itemView.findViewById(R.id.tvLogin);
    }
    public void setData(ResponseDTO responseDTO){
        if(responseDTO.getOwner().getAvatarUrl() != null) {
            Glide.with(mTvImage).load(responseDTO.getOwner().getAvatarUrl()).into(mTvImage);
        } else {
            mTvImage.setImageResource(R.drawable.ic_launcher_background);
        }
        mTvName.setText(responseDTO.getName());
        mTvLogin.setText(responseDTO.getOwner().getLogin());
    }
}

