package com.cheesycode.firebase.chat.demo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;



public class MessageService  {


    public void onNewToken(String token) {
        Log.d("MESSAGING_TOKEN", "Refreshed token: " + token);
        createNotificationChannel();
    }


    public void onMessageReceived() {
    }

    private void createNotificationChannel() {
    }
}
