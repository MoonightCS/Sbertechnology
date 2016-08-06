package ru.sbt.bodya.hw5;

public class Account {


    private final String name;
    private final String surname;
    private int money;
    private final int pinCode;

    public Account(String name, String surname, int money, int pinCode) {

        this.name = name;
        this.surname = surname;
        this.money = money;
        this.pinCode = pinCode;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPinCode() {
        return pinCode;
    }


}
