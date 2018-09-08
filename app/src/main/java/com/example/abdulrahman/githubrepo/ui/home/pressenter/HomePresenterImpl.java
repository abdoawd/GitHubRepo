package com.example.abdulrahman.githubrepo.ui.home.pressenter;

import android.view.View;

import com.example.abdulrahman.githubrepo.db.CachedRepoModel;
import com.example.abdulrahman.githubrepo.entity.Repo;
import com.example.abdulrahman.githubrepo.ui.home.model.HomeModel;
import com.example.abdulrahman.githubrepo.ui.home.model.HomeModelImpl;
import com.example.abdulrahman.githubrepo.ui.home.view.HomeView;
import com.example.abdulrahman.githubrepo.utils.NetworkUtils;
import java.lang.ref.WeakReference;
import java.util.List;


public class HomePresenterImpl implements HomePresenter, HomeModel.GetCachedReposCallback,HomeModel.GetOnlineReposCallback {
    private HomeModel model;
    private WeakReference<HomeView> viewReference;
    public HomePresenterImpl(HomeView viewReference) {
        this.viewReference = new WeakReference<>(viewReference);
        model = new HomeModelImpl();
    }

    @Override
    public void init() {
        if (NetworkUtils.isOnline()){
            getRepos();
        }
        else {
            getCachedRepos();
        }
    }

    private void getCachedRepos() {
        getView().showProgressBar();
        model.getCachedRepo(this);
    }

    @Override
    public void clear() {
        model.cancelRequest();
        viewReference.clear();
        viewReference = null;
    }

    private void getRepos() {
        getView().showProgressBar();
        model.getReposOnlineList(this);
    }



    @Override
    public void onGettingOnlineRepoSuccess(List<Repo> repos) {
        if (isViewCleared())
            return;
        getView().hideProgressBar();
        getView().setListItems(repos);
    }

    private boolean isViewCleared() {
        return viewReference == null;
    }

    @Override
    public void onGettingOnlineRepoFailure() {
        if (isViewCleared())
            return;
        getView().hideProgressBar();
        getView().showConnectionError(onRetryBtnClicked());
    }

    private View.OnClickListener onRetryBtnClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRepos();
            }
        };
    }

    private HomeView getView() {
        return viewReference.get();
    }

    @Override
    public void onGettingCachedRepoSuccess(List<CachedRepoModel> list) {
        getView().hideProgressBar();
        getView().setCachedList(list);

    }

    @Override
    public void onGettingCachedRepoFailure() {

    }
}
