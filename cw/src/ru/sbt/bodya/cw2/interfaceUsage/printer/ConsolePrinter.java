package ru.sbt.bodya.cw2.interfaceUsage.printer;

public class ConsolePrinter implements IPrinter {

    @Override
    public void print(String text) {
        System.out.println(text);
    }

}
