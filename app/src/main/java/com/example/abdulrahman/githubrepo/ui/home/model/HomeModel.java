package com.example.abdulrahman.githubrepo.ui.home.model;

import com.example.abdulrahman.githubrepo.entity.Repo;

import java.util.List;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public interface HomeModel {
    void getCategoriesList(GetCategoriesCallback callback);

    void cancelCategoriesRequest();

    interface GetCategoriesCallback {
        void onGettingCategoriesSuccess(List<Repo> categories);

        void onGettingCategoriesFailure();
    }
}
