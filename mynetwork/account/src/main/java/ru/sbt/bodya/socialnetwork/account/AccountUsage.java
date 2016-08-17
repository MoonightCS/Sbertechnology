package ru.sbt.bodya.socialnetwork.account;

import ru.sbt.bodya.socialnetwork.account.domain.Account;

public interface AccountUsage {


    void addFriend(Account account, Account friend);

    void deleteFriend(Account account, Account friend);

    void makeEntryOnTheWall(Account account, String entry);





}
