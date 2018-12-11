package com.cheesycode.firebase.chat.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PushNotificationReceived extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notification_received);

        String message = getIntent().getStringExtra("message");

        TextView textView = findViewById(R.id.textView);
        textView.append(message);

    }
}
