package ru.sbt.bodya.socialnetwork.message;

import ru.sbt.bodya.socialnetwork.account.domain.Account;
import ru.sbt.bodya.socialnetwork.message.domain.Message;

import java.util.List;

public interface MessageUsage {

    void sendMessage(Message message);

    List<Message> readChatwith(Account from, Account with);



}
