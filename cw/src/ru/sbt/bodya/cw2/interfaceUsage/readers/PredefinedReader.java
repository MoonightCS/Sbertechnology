package ru.sbt.bodya.cw2.interfaceUsage.readers;

public class PredefinedReader implements IReader {

    private final String str;

    public PredefinedReader(final String str) {
        this.str = str;
    }

    @Override
    public String read() {
        return str;
    }
}
