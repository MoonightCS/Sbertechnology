package ru.sbt.bodya.hw5;

public interface Terminal {

    int checkAccount(Integer numCard, Integer pin);

    int getMoney(int cardNumber, int sum);

    void putMoney(int cardNumber, int sum);


}
