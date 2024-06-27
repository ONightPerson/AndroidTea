package com.liubz.androidtea.repo.model;

import com.liubz.androidtea.network.retrofit.data.Repo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface RepoService {

    @GET("/users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);
}
