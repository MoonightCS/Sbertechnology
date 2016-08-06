package ru.sbt.bodya.hw5.exceptions;

public class AccountIsLockedException extends RuntimeException {

    public AccountIsLockedException(String message) {
        super(message);
    }

}
