package com.dzo.notificationdemocheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager notificationManager;
    public final String NOTIFICATION_ID = "1";
    public final String NOTIFICATION_NAME ="myNotification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            creteNotification();
        }
    }
    private void creteNotification() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_ID,NOTIFICATION_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }

    public void showNotification(View view) {
        NotificationCompat.Builder n = new NotificationCompat.Builder(this,NOTIFICATION_ID);
        n.setContentTitle("Hey This is My First Notification Send");
        n.setContentText("Send By Android Notification Manager");
        n.setSmallIcon(R.drawable.ic_android_black_24dp);
        n.setVibrate(new long[] { 1000, 1000 });
        n.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        notificationManager.notify(1,n.build());

    }
}