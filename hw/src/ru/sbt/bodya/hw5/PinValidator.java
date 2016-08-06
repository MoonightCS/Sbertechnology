package ru.sbt.bodya.hw5;

import ru.sbt.bodya.hw5.exceptions.BadConnectException;
import ru.sbt.bodya.hw5.exceptions.PinValidateException;


public class PinValidator {


    private final TerminalServer terminalServer;
    public int errorCount = 0;

    public PinValidator(TerminalServer terminalServer) {
        this.terminalServer = terminalServer;
    }

    public int checkPinCode(Integer numCard, int pin) throws PinValidateException, BadConnectException {

        if (Math.random() > 0.99) {
            throw new BadConnectException("Bad connect exception");
        }

        if (terminalServer.getPinCode(numCard) == pin) {

            errorCount = 0;
            return errorCount;

        } else {

            if (errorCount >= 2) {
                throw new PinValidateException("3 incorrect pin codes, need to wait 5 seconds");
            }
            errorCount++;

        }

        return errorCount;

    }

}
