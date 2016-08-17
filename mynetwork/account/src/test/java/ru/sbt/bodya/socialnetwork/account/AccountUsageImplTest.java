package ru.sbt.bodya.socialnetwork.account;

import org.junit.Test;
import ru.sbt.bodya.socialnetwork.account.domain.Account;

import java.util.Date;

import static org.junit.Assert.*;

public class AccountUsageImplTest {

    AccountUsageImpl accountUsage = new AccountUsageImpl();


    @Test
    public void addFriend() throws Exception {

        Account account1 = new Account("Bogdan", "123", "Male", new Date(1231241231));
        Account account2 = new Account("Maryana", "321", "Female", new Date(1231241231));

        accountUsage.addFriend(account1, account2);

        assertEquals(true, account1.getAllFriends().contains(account2));
        assertEquals(true, account2.getAllFriends().contains(account1));

    }

    @Test
    public void deleteFriend() throws Exception {

        Account account1 = new Account("Bogdan", "123", "Male", new Date(1231241231));
        Account account2 = new Account("Maryana", "321", "Female", new Date(1231241231));
        Account account3 = new Account("Dasha", "321", "Female", new Date(1231241231));

        accountUsage.addFriend(account1, account2);
        accountUsage.addFriend(account1, account3);
        accountUsage.addFriend(account2, account3);

        accountUsage.deleteFriend(account2, account3);

        assertEquals(true, account1.getAllFriends().contains(account2));
        assertEquals(true, account1.getAllFriends().contains(account3));
        assertEquals(true, account3.getAllFriends().contains(account1));
        assertEquals(false, account2.getAllFriends().contains(account3));
        assertEquals(false, account3.getAllFriends().contains(account2));


    }

    @Test
    public void makeEntryOnTheWall() throws Exception {

        Account account1 = new Account("Bogdan", "123", "Male", new Date(1231241231));

        account1.getWall().add("Hello ru");
        account1.getWall().add("Hello sbt");
        account1.getWall().add("Hello bodya");

        assertEquals(true, account1.getWall().contains("Hello ru"));
        assertEquals(true, account1.getWall().contains("Hello bodya"));
        assertEquals(true, account1.getWall().contains("Hello sbt"));
        assertEquals(false, account1.getWall().contains("Hello ru.sbt.bodya"));


    }

}