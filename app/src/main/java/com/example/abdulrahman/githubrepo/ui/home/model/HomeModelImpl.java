package com.example.abdulrahman.githubrepo.ui.home.model;


import android.util.Log;

import com.example.abdulrahman.githubrepo.applicatoin.App;
import com.example.abdulrahman.githubrepo.db.CachedRepoDataSource;
import com.example.abdulrahman.githubrepo.db.CachedRepoModel;
import com.example.abdulrahman.githubrepo.entity.Repo;
import com.example.abdulrahman.githubrepo.network.ApiClient;
import com.example.abdulrahman.githubrepo.network.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeModelImpl implements HomeModel {

    CachedRepoDataSource
            dataSource = new CachedRepoDataSource(App.getContext());
    private Call<List<Repo>> call;
    private List<CachedRepoModel> list;

    @Override
    public void getReposOnlineList(final GetOnlineReposCallback callback,int startPage,int endPage) {
        call = ApiClient.getApiService().getScheduledRepos(startPage,endPage, Constants.ACCESS_TOKEN);
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                if (response.isSuccessful()) {
                    int i =response.body().size();
                    callback.onGettingOnlineRepoSuccess(response.body());
                    dataSource.clearCachedData();
                    dataSource.CachRepotoDB(response.body());
                } else {

                    callback.onGettingOnlineRepoFailure();
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.d(t.getMessage(), "failure");
                Log.d("failure", t.getMessage());
                callback.onGettingOnlineRepoFailure();
            }
        });
    }

    @Override
    public void cancelRequest() {
        if (call != null)
            call.cancel();

    }

    @Override
    public void getCachedRepo(GetCachedReposCallback callback) {
        list = dataSource.getAllRepo();
        if (list.size() > 0) {
            callback.onGettingCachedRepoSuccess(list);
        } else {
            callback.onGettingCachedRepoFailure();
        }

    }

    @Override
    public void refreshDataInRecycler(final RefreshReposCallback refreshReposCallback) {
        call = ApiClient.getApiService().getAllRepos(Constants.ACCESS_TOKEN);
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                if (response.isSuccessful()) {
                    refreshReposCallback.onRefreshedSuccess(response.body());
                    dataSource.clearCachedData();
                    dataSource.CachRepotoDB(response.body());
                } else {

                    refreshReposCallback.onRefreshedRepoFailure();
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.d(t.getMessage(), "failure");
                Log.d("failure", t.getMessage());
                refreshReposCallback.onRefreshedRepoFailure();
            }
        });

    }

    @Override
    public void udateCachedRepo(final UpdateCachedRepoCalback callback) {
        call = ApiClient.getApiService().getAllRepos(Constants.ACCESS_TOKEN);
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                if (response.isSuccessful()) {
                    callback.onUpdatingCachedSuccess();
                    dataSource.clearCachedData();
                    dataSource.CachRepotoDB(response.body());
                } else {

                    callback.onUpdatingCachedFailure();
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.d(t.getMessage(), "failure");
                Log.d("failure", t.getMessage());
                callback.onUpdatingCachedFailure();
            }
        });

    }
}