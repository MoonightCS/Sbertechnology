package ru.sbt.bodya.hw6;

public class Account {


    private final String name;
    private final String surname;
    private final int money;
    private final int pinCode;

    public Account(String name, String surname, int money, int pinCode) {

        this.name = name;
        this.surname = surname;
        this.money = money;
        this.pinCode = pinCode;
    }


    @Override
    public String toString() {
        return "Account: {" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", money=" + money +
                ", pinCode=" + pinCode +
                '}';
    }
}
