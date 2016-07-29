package ru.sbt.bodya.cw2.abstractUsage;

public abstract class AbstractSmileProcessor {

    public void process() {
        final String text = this.readString();
        final String result = text.replace(":)","=)");
        System.out.println(result);
    }

    protected abstract String readString();

}
