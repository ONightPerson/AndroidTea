package com.liubz.androidtea.network.retrofit.service;

import com.liubz.androidtea.network.retrofit.data.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CustomService {

    @GET("/users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
