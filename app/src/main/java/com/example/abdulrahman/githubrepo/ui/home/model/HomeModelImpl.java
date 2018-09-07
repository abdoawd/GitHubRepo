package com.example.abdulrahman.githubrepo.ui.home.model;


import android.util.Log;

import com.example.abdulrahman.githubrepo.entity.Repo;
import com.example.abdulrahman.githubrepo.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeModelImpl implements HomeModel {

    private Call<List<Repo>> call;

    @Override
    public void getCategoriesList(final GetCategoriesCallback callback) {
        call = ApiClient.getApiService().getAllRepos();
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                if (response.isSuccessful()) {
                    callback.onGettingCategoriesSuccess(response.body());
                } else {

                    callback.onGettingCategoriesFailure();
                }
            }
            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.d(t.getMessage(),"failure");
                Log.d("failure",t.getMessage());
                callback.onGettingCategoriesFailure();
            }
        });
    }

    @Override
    public void cancelCategoriesRequest() {
        if (call != null)
            call.cancel();

    }
}