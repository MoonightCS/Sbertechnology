package ru.sbt.bodya.socialnetwork.account;

import ru.sbt.bodya.socialnetwork.account.domain.Account;

public class AccountUsageImpl implements AccountUsage {

    @Override
    public void addFriend(Account account, Account friend) {

        if (!account.getAllFriends().contains(friend)) {
            account.getAllFriends().add(friend);
            friend.getAllFriends().add(account);
        }

    }

    @Override
    public void deleteFriend(Account account, Account friend) {
        account.getAllFriends().remove(friend);
        friend.getAllFriends().remove(account);

    }

    @Override
    public void makeEntryOnTheWall(Account account, String entry) {

        account.getWall().add(entry);

    }
}
