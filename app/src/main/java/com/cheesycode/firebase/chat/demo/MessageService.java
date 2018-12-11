package com.cheesycode.firebase.chat.demo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
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
        SendTokenToFirebase(token);
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
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(11, mBuilder.build());


    }

    private void SendTokenToFirebase(String token){
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_id);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel( getString(R.string.channel_id) ,name, importance);
            channel.setDescription(description);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
