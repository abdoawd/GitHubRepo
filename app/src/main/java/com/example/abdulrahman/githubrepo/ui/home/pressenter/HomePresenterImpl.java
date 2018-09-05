package com.example.abdulrahman.githubrepo.ui.home.pressenter;

import android.view.View;

import com.example.abdulrahman.githubrepo.entity.Repo;
import com.example.abdulrahman.githubrepo.ui.home.model.HomeModel;
import com.example.abdulrahman.githubrepo.ui.home.model.HomeModelImpl;
import com.example.abdulrahman.githubrepo.ui.home.view.HomeView;

import java.lang.ref.WeakReference;
import java.util.List;


public class HomePresenterImpl implements HomePresenter, HomeModel.GetCategoriesCallback {
    private HomeModel model;
    private WeakReference<HomeView> viewReference;

    public HomePresenterImpl(HomeView viewReference) {
        this.viewReference = new WeakReference<>(viewReference);
        model = new HomeModelImpl();
    }

    @Override
    public void init() {
        getCategories();
    }

    private void getCategories() {
        getView().showProgressBar();
        model.getCategoriesList(this);
    }

    @Override
    public void clear() {
        model.cancelCategoriesRequest();
        viewReference.clear();
        viewReference = null;
    }

    @Override
    public void onGettingCategoriesSuccess(List<Repo> repos) {
        if (isViewCleared())
            return;
        getView().hideProgressBar();
        getView().setListItems(repos);
    }

    private boolean isViewCleared() {
        return viewReference == null;
    }

    @Override
    public void onGettingCategoriesFailure() {
        if (isViewCleared())
            return;
        getView().hideProgressBar();
        getView().showConnectionError(onRetryBtnClicked());
    }

    private View.OnClickListener onRetryBtnClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCategories();
            }
        };
    }

    private HomeView getView() {
        return viewReference.get();
    }
}
