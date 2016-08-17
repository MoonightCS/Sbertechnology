package ru.sbt.bodya.socialnetwork.message.domain;

import ru.sbt.bodya.socialnetwork.account.domain.Account;

import java.util.Date;

public class Message {


    private final Account from;
    private final Account to;
    private final String message;


    public Message(Account fromId, Account toId, String message) {
        this.from = fromId;
        this.to = toId;
        this.message = message;

    }

    public Account getFromId() {
        return from;
    }

    public Account getToId() {
        return to;
    }

    public String getMessage() {
        return message;
    }




}
