package com.cheesycode.firebase.chat.demo;

public class Conversation {
    public String user_one;
    public String user_two;
    public String[] messages;

    public Conversation(String user_one, String user_two, String[] messages) {
        this.user_one = user_one;
        this.user_two = user_two;
        this.messages = messages;
    }

    public Conversation(){}
}
