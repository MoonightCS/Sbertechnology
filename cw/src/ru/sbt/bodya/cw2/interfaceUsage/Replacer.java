package ru.sbt.bodya.cw2.interfaceUsage;


import ru.sbt.bodya.cw2.interfaceUsage.printer.AdvConsolePrinter;
import ru.sbt.bodya.cw2.interfaceUsage.printer.ConsolePrinter;
import ru.sbt.bodya.cw2.interfaceUsage.printer.IPrinter;
import ru.sbt.bodya.cw2.interfaceUsage.readers.IReader;
import ru.sbt.bodya.cw2.interfaceUsage.readers.PredefinedReader;

public class Replacer {

    private final IReader reader;

    private final IPrinter printer;

    public Replacer(final IReader reader, final IPrinter printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public void replace() {

        final String text = reader.read();
        final String replacedText = text.replace(":)","=)");
        printer.print(replacedText);

    }


    public static void main(String[] args) {
        final IReader reader = new PredefinedReader(":)hjgjhgj:)gjhgjhgj:)");
        final IPrinter printer = new ConsolePrinter();
        final IPrinter advPrinter = new AdvConsolePrinter();

        final Replacer replacer = new Replacer(reader, printer);
        final Replacer advReplacer = new Replacer(reader, advPrinter);

        replacer.replace();
        advReplacer.replace();
    }
}
