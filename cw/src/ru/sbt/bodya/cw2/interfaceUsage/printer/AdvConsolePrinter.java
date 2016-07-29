package ru.sbt.bodya.cw2.interfaceUsage.printer;

public class AdvConsolePrinter implements IPrinter {

    @Override
    public void print(String text) {
        System.out.println(text);
        System.out.println(String.format("String length:%d", text.length()));
    }


}
