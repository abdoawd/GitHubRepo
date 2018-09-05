package com.example.abdulrahman.githubrepo.ui.home.view;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.abdulrahman.githubrepo.R;
import com.example.abdulrahman.githubrepo.entity.Repo;
import com.example.abdulrahman.githubrepo.ui.home.pressenter.HomePresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeView {
    @BindView(R.id.progressBar_main)
    ProgressBar progressBar;
    @BindView(R.id.recycler_main)
    RecyclerView recyclerView;
    ReposAdapter adapter;
    @BindView(R.id.container_main)
    ConstraintLayout constraintLayout;
    private HomePresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new HomePresenterImpl(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new ReposAdapter();
        recyclerView.setAdapter(adapter);
        presenter.init();
    }

    @Override
    public void showConnectionError(View.OnClickListener onClickListener) {
        Snackbar.make(constraintLayout, R.string.connection_eror, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.retry, onClickListener)
                .show();

    }

    @Override
    public void setListItems(List<Repo> list) {
        adapter.setItems(list);

    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);

    }
}
