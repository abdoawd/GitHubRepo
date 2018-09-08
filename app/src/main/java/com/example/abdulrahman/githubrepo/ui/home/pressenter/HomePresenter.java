package com.example.abdulrahman.githubrepo.ui.home.pressenter;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public interface HomePresenter {
    void init(int startPage,int endPage);

    void clear();

    void onRefreshSwiped();
}
