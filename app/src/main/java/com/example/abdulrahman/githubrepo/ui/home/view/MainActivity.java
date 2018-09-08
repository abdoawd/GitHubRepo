package com.example.abdulrahman.githubrepo.ui.home.view;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.abdulrahman.githubrepo.R;
import com.example.abdulrahman.githubrepo.db.CachedRepoModel;
import com.example.abdulrahman.githubrepo.entity.Repo;
import com.example.abdulrahman.githubrepo.services.MyService;
import com.example.abdulrahman.githubrepo.ui.home.pressenter.HomePresenterImpl;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.security.ProviderInstaller;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeView, ProviderInstaller.ProviderInstallListener,
        SwipeRefreshLayout.OnRefreshListener {
    private int errorCode = 0;
    private int ERROR_DIALOG_REQUEST_CODE = 1;

    @BindView(R.id.progressBar_main)
    ProgressBar progressBar;

    @BindView(R.id.recycler_main)
    RecyclerView recyclerView;


    @BindView(R.id.container_main)
    ConstraintLayout constraintLayout;

    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    ReposAdapter adapter;
    CachedRepoAdapter cachedRepoAdapter;
    private HomePresenterImpl presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ProviderInstaller.installIfNeededAsync(this, this);
        init();

    }

    private void init() {
        presenter = new HomePresenterImpl(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cachedRepoAdapter = new CachedRepoAdapter(this);
        adapter = new ReposAdapter(this);
        presenter.init();
        startService();
        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                addDataToList();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(this);

    }

    private void addDataToList() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 300; i++) {
                }
                progressBar.setVisibility(View.GONE);
            }
        }, 1500);
    }

    @Override
    public void showConnectionError(View.OnClickListener onClickListener) {
        Snackbar.make(constraintLayout, R.string.connection_eror, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.retry, onClickListener)
                .show();
    }
    public void startService() {
        startService(new Intent(this, MyService.class));
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(this, MyService.class);
        PendingIntent pintent = PendingIntent
                .getService(this, 0, intent, 0);
        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        // Start service every hour
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                3600 * 1000, pintent);
    }

    @Override
    public void setListItems(List<Repo> list) {
        adapter.setItems(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setCachedList(List<CachedRepoModel> list) {
        cachedRepoAdapter.setItems(list);
        recyclerView.setAdapter(cachedRepoAdapter);
    }

    public void showAlertDialogButtonClicked(final String repoHtml, final String repoOwnerHtl) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("choose repo to browse");

        // add a list
        String[] items = {"repository `html_url`", "owner `html_url`"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent browserIntent;
                switch (which) {
                    case 0:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(repoOwnerHtl));
                        startActivity(browserIntent);
                        break;
                    case 1:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(repoHtml));
                        startActivity(browserIntent);
                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);

    }

    // coming implmented methods to slove problem with ssl forced me on android <4.4
    @Override
    public void onProviderInstalled() {
    }

    @Override
    public void onProviderInstallFailed(int i, Intent intent) {
        GoogleApiAvailability availability = GoogleApiAvailability.getInstance();
        if (availability.isGooglePlayServicesAvailable(MainActivity.this) == errorCode) {
            // Recoverable error. Show a dialog prompting the user to
            // install/update/enable Google Play services.
            availability.showErrorDialogFragment(
                    this,
                    errorCode,
                    ERROR_DIALOG_REQUEST_CODE,
                    new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            // The user chose not to take the recovery action
                            onProviderInstalled();
                        }
                    });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onRefresh() {
        Snackbar.make(constraintLayout, R.string.swipeRefre, Snackbar.LENGTH_LONG).show();
        swipeRefreshLayout.setRefreshing(false);
    }
}
