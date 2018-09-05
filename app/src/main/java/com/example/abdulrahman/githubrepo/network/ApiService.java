package com.example.abdulrahman.githubrepo.network;



import com.example.abdulrahman.githubrepo.entity.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface ApiService {

    @GET("square/repos?access_token=3880f0116c026876f8c3117ddb43c8748e521344")
    Call<List<Repo>> getMainCategories();

    @GET("GetCategories")
    Call<List<String>> getSubCategories(@Query("categoryId") int categoryId, @Query("countryId") int countryId);

}
