package com.example.abdulrahman.githubrepo.ui.home.view;

import android.view.View;

import com.example.abdulrahman.githubrepo.db.CachedRepoModel;
import com.example.abdulrahman.githubrepo.entity.Repo;

import java.util.List;


public interface HomeView {
    void showConnectionError(View.OnClickListener onClickListener);

    void setListItems(List<Repo> list);

    void hideProgressBar();

    void showProgressBar();


    void setCachedList(List<CachedRepoModel> list);
}