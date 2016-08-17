package ru.sbt.bodya.socialnetwork.account.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Account {

    private String name;
    private String password;
    private String gender;
    private Date dateOfBirth;

    private List<Account> allFriends;
    private List<String> wall;


    public Account(String name, String password, String gender, Date dateOfBirth) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        allFriends = new ArrayList<>();
        wall = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Account> getAllFriends() {
        return allFriends;
    }

    public List<String> getWall() {
        return wall;
    }
}
