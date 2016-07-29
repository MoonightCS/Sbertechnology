package ru.sbt.bodya.cw2.abstractUsage;

public class FileSmileProcessor extends AbstractSmileProcessor {

    @Override
    protected String readString() {
        return "text from :) file:) :)";
    }

    public static void main(String[] args) {
        FileSmileProcessor fileSmileProcessor = new FileSmileProcessor();
        fileSmileProcessor.process();

    }
}
