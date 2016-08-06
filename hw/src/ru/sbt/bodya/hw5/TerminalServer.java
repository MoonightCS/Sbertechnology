package ru.sbt.bodya.hw5;

public class TerminalServer {

    private Db dataBase;


    public TerminalServer(Db database) {

        this.dataBase = database;

    }

    int getPinCode(int cardNumber) {

        return dataBase.getDb().get(cardNumber).getPinCode();

    }

    int getMoney(int cardNumber) {

        return dataBase.getDb().get(cardNumber).getMoney();

    }

    public Db getDataBase() {
        return dataBase;
    }
}



