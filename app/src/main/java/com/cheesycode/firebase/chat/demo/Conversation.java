package com.cheesycode.firebase.chat.demo;

import java.util.ArrayList;

public class Conversation {
    public String user_one;
    public String user_two;
    public ArrayList<String> messages;

    public Conversation(String user_one, String user_two, ArrayList<String> messages) {
        this.user_one = user_one;
        this.user_two = user_two;
        this.messages = messages;
    }

    public Conversation(){}
}
