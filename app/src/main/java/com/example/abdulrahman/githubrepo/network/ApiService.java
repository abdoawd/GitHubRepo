package com.example.abdulrahman.githubrepo.network;



import com.example.abdulrahman.githubrepo.entity.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface ApiService {

    @GET("square/repos")
    Call<List<Repo>> getAllRepos(@Query("access_token") String access_token);
//    https://api.github.com/user/repos?page=2&per_page=100

    @GET("square/repos?")
    Call<List<Repo>> getScheduledRepos(@Query("page") int page,@Query("per_page") int per_page,
                                        @Query("access_token") String access_token);
}
