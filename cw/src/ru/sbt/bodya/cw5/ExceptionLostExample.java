package ru.sbt.bodya.cw5;

public class ExceptionLostExample {


    public static void exceptionLost() {

        try {

            //ThrowSomeException();
            throw new Exception("A");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }

    private static void ThrowSomeException() throws Exception{

        throw new Exception("B");

    }

    public static void main(String[] args) {

        exceptionLost();

    }
}
