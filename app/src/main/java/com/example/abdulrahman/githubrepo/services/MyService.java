package com.example.abdulrahman.githubrepo.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.example.abdulrahman.githubrepo.R;
import com.example.abdulrahman.githubrepo.ui.home.model.HomeModel;
import com.example.abdulrahman.githubrepo.ui.home.model.HomeModelImpl;
import com.example.abdulrahman.githubrepo.ui.home.view.MainActivity;

public class MyService extends Service implements HomeModel.UpdateCachedRepoCalback {
    private HomeModel model;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        model = new HomeModelImpl();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        model.udateCachedRepo(this);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Servics Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public void onUpdatingCachedSuccess() {
        Intent intentt = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intentt, 0);

        // Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(this)
                .setContentTitle("Check Refresh data from githup")
                .setContentText("Refresh data")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentIntent(pIntent)
                .addAction(R.drawable.notification_icon, "And more", pIntent).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, noti);
    }

    @Override
    public void onUpdatingCachedFailure() {

    }
}
