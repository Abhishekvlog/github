package com.example.githubprofiles;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/users/{user}/repos")
    Call<List<ResponseDTO>> getProfiles(@Path("user") String user);
}