package com.example.abdulrahman.githubrepo.ui.home.model;

import com.example.abdulrahman.githubrepo.db.CachedRepoModel;
import com.example.abdulrahman.githubrepo.entity.Repo;

import java.util.List;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public interface HomeModel {
    void getReposOnlineList(GetOnlineReposCallback callback);

    void cancelRequest();

    void getCachedRepo(GetCachedReposCallback callback);

    interface GetOnlineReposCallback {
        void onGettingOnlineRepoSuccess(List<Repo> list);
        void onGettingOnlineRepoFailure();
    }

    interface GetCachedReposCallback {
        void onGettingCachedRepoSuccess(List<CachedRepoModel> list);

        void onGettingCachedRepoFailure();
    }
    void udateCachedRepo(UpdateCachedRepoCalback updateCachedRepoCalback);
    interface UpdateCachedRepoCalback {
        void onUpdatingCachedSuccess();

        void onUpdatingCachedFailure();
    }
}
