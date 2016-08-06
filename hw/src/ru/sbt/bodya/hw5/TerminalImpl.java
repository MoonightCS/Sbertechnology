package ru.sbt.bodya.hw5;

import ru.sbt.bodya.hw5.exceptions.*;

public class TerminalImpl implements Terminal {


    private final TerminalServer server;
    private final PinValidator pinValidator;
    private int errorCount = 0;
    private int previousCard = 0;
    private long waitTime = 0;
    private boolean access = false;



    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    @Override
    public int checkAccount(Integer numCard, Integer pin) {

        try {
            if (pin == null) {
                throw new NoPinCodeException("No pin code");
            }

            if (checkAccBlock()) {

                if (numCard != previousCard) {
                    access = false;
                }

                try {
                    errorCount = pinValidator.checkPinCode(numCard, pin);

                    if (errorCount == 0) {

                        previousCard = numCard;
                        access = true;
                        return this.server.getMoney(numCard);

                    } else {

                        if (errorCount <= 3) {

                            System.out.printf("Вы ввели неверный пинкод, осталось %d попытки(ка)\n", 3 - errorCount);
                            access = false;

                        }

                    }
                } catch (PinValidateException e) {

                    System.out.println("Вы потратили лимит на неккоректные пинкоды, доступ к аккаунту " +
                            "закрыт на 5 секунд");
                    waitTime = System.currentTimeMillis();

                } catch (BadConnectException e2) {

                    System.out.println("Плохое соединение с сервером, попробуйте еще раз");

                }
            }

        } catch (AccountIsLockedException e3) {

            throw new TerminalException("checking pin code exception", e3);

        }
        return 0;

    }


    private boolean checkAccBlock() {

        if (this.waitTime != 0) {

            if (System.currentTimeMillis() - waitTime < 5000) {

                throw new AccountIsLockedException("You must wait " + (5000 - (System.currentTimeMillis() - waitTime) / 1000
                        + " seconds"));

            } else {

                this.waitTime = 0;
                pinValidator.errorCount = 0;
                return true;

            }
        }

        return true;
    }

    @Override
    public int getMoney(int cardNumber, int sum) {

        int tmp;

        if (cardNumber != previousCard) {
            access = false;
        }

        if (access) {

            try {
                if (checkAccBlock()) {

                    tmp = server.getMoney(cardNumber);

                    if (sum % 100 == 0 && tmp > sum) {
                        server.getDataBase().changeSum(cardNumber, sum, -1);
                    }

                }
            } catch (AccountIsLockedException e3) {
                throw new TerminalException("checking pin code exception", e3);
            }

            return sum;

        }
        else throw new NoPinCodeException("No pin code");
    }

    @Override
    public void putMoney(int cardNumber, int sum) {


        if (cardNumber != previousCard) {
            access = false;
        }

        if (access) {

            try {
                if (checkAccBlock()) {

                    if (sum % 100 == 0) {
                        server.getDataBase().changeSum(cardNumber, sum, 1);
                    }

                }
            } catch (AccountIsLockedException e3) {
                throw new TerminalException("checking pin code exception", e3);
            }
        }
        else throw new NoPinCodeException("No pin code");
    }




}
