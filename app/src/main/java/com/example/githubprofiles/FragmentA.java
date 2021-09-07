package com.example.githubprofiles;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentA extends Fragment {
    private EditText mEtGithubId;
    private Button mBtnCallApi;
    private RecyclerView recyclerView;
    private List<ResponseDTO> ModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtGithubId = view.findViewById(R.id.EtEnterID);
        mBtnCallApi = view.findViewById(R.id.BtnRequest);
        recyclerView = view.findViewById(R.id.recyclerview);
        ModelList = new ArrayList<>();
        mBtnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallApi();
            }
        });

    }
    private void CallApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        String  PostId = mEtGithubId.getText().toString();
        apiService.getProfiles(PostId).enqueue(new Callback<List<ResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ResponseDTO>> call, Response<List<ResponseDTO>> response) {
                if (response.body() != null){
                    ModelList = response.body();
                    setRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView() {
        PostAdapter postAdapter = new PostAdapter(ModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(postAdapter);
    }
}