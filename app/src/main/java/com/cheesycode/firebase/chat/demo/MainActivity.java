package com.cheesycode.firebase.chat.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;
    private EditText message;
    private EditText messageHistory;
    private TextView other_user;
    private Conversation lastConversation;
    private String documentId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageHistory = findViewById(R.id.editText);
        other_user = findViewById(R.id.other_user);
        message = findViewById(R.id.message);

        createSignInIntent();

        subscribeToTopic();

    }

    private void GetMessages(String username) {

    }

    public void SendMessage(View v) {

    }


    private void subscribeToTopic() {

    }

    private void createSignInIntent() {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void SignOut() {
//        AuthUI.getInstance()
//                .signOut(this)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // ...
//                    }
//                });
    }

    public void DeleteUser() {
//        AuthUI.getInstance()
//                .delete(this)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // ...
//                    }
//                });
    }
}
