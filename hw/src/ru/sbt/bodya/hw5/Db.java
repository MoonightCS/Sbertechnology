package ru.sbt.bodya.hw5;


import java.util.HashMap;
import java.util.Map;

public class Db {

    private Map<Integer, Account> hashMap = new HashMap<>();

    public Db() {

        this.hashMap.put(1231, new Account("Bodya", "Popov", 500, 1111));
        this.hashMap.put(1232, new Account("Dima", "Popovetkin", 600, 1112));
        this.hashMap.put(1233, new Account("Genya", "Guschin", 700, 1113));
        this.hashMap.put(1234, new Account("Petya", "Gayda", 400, 1114));
        this.hashMap.put(1235, new Account("Maryana", "Antonova", 200, 1115));
        this.hashMap.put(1236, new Account("Tanya", "Matveenko", 300, 1116));
        this.hashMap.put(1237, new Account("Katya", "Kondranina", 100, 1117));
        this.hashMap.put(1238, new Account("Liza", "Potapova", 900, 1118));
    }

    public void addAcc(int cardNumber, Account account) {

        this.hashMap.put(cardNumber, account);

    }

    public void deleteAcc(int cardNumber) {

        this.hashMap.remove(cardNumber);

    }

    public void changeSum(int cardNumber, int money, int sign) {

        this.hashMap.get(cardNumber).setMoney(this.hashMap.get(cardNumber).getMoney() + sign * money);

    }

    public Map<Integer, Account> getDb() {
        return hashMap;
    }


}
