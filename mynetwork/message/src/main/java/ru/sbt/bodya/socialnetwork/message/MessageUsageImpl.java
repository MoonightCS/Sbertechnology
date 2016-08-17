package ru.sbt.bodya.socialnetwork.message;

import ru.sbt.bodya.socialnetwork.account.domain.Account;
import ru.sbt.bodya.socialnetwork.message.domain.Message;

import java.util.*;

public class MessageUsageImpl implements MessageUsage {

    private final Map<Account, List<Message>> currentUserChats = new HashMap<>();

    @Override
    public void sendMessage(Message message) {

    }

    @Override
    public List<Message> readChatwith(Account from, Account with) {
        return null;
    }
}
