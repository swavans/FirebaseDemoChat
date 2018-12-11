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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessageService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        Log.d("MESSAGING_TOKEN", "Refreshed token: " + token);
        createNotificationChannel();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("NEW_MESSASGE", "From: " + remoteMessage.getFrom());
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, getResources().getString(R.string.channel_id))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Test")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentText(remoteMessage.getData().toString())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
        String message = remoteMessage.getData().get("test").toString();

        Intent pushReceivedIntent = new Intent(getApplicationContext(), PushNotificationReceived.class);

        pushReceivedIntent.putExtra("message", message);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, pushReceivedIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(pendingIntent);



        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(11, mBuilder.build());


    }

    private void createNotificationChannel() {
    }
}
