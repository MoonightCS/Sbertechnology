package ru.sbt.bodya.hw5;

import ru.sbt.bodya.hw5.exceptions.AccountIsLockedException;
import ru.sbt.bodya.hw5.exceptions.NoPinCodeException;
import ru.sbt.bodya.hw5.exceptions.TerminalException;

import java.util.Map;

public class TerminalTest {

    public static void main(String[] args) throws InterruptedException{

        // Создание базы данных клиентов, сервера, валидатора, а также самого терминала

        System.out.println("Клиентская база до добавления клиента");

        Db dataBase = new Db();

        TerminalServer terminalServer = new TerminalServer(dataBase);

        PinValidator pinValidator = new PinValidator(terminalServer);

        Terminal terminal = new TerminalImpl(terminalServer, pinValidator);

        for (Map.Entry<Integer, Account> entry: dataBase.getDb().entrySet()) {

            System.out.printf("Номер карты: %d; Имя: %s; Количество средств: %d\n", entry.getKey(),
                    entry.getValue().getName(), entry.getValue().getMoney());

        }

        System.out.println();

        //

        // Добавление новых клиентов в базу, удланение существующих клинетов в базе

        dataBase.addAcc(1239,new Account("Artem", "Popov", 1100, 1119));
        System.out.println("Клиентская база после добавления клиента");
        for (Map.Entry<Integer, Account> entry: dataBase.getDb().entrySet()) {

            System.out.printf("Номер карты: %d; Имя: %s; Количество средств: %d\n", entry.getKey(),
                    entry.getValue().getName(), entry.getValue().getMoney());

        }

        System.out.println();
        dataBase.deleteAcc(1236);
        System.out.println("Клиентская база после удаления клиента");
        for (Map.Entry<Integer, Account> entry: dataBase.getDb().entrySet()) {

            System.out.printf("Номер карты: %d; Имя: %s; Количество средств: %d\n", entry.getKey(),
                    entry.getValue().getName(), entry.getValue().getMoney());

        }

        System.out.println();

        //

        // Создание ситуации, при которой аккаунт заблочится на 5 секунд, после чего мы ждем 5 секунд,
        // чтобы снова использовать данный аккаунт.


        System.out.println("Ситуация, когда 3 раза ввели неправильный пинкод и ждем 5 секунд");
        int tmp;
        for (int i = 0; i < 3; i++) {

            tmp = terminal.checkAccount(1231, 1112);
            if (tmp != 0) {

                System.out.println(tmp);

            }
        }

        Thread.sleep(5000);

        tmp = terminal.checkAccount(1231, 1111);

        System.out.printf("Дорогой обладатель карты No_%d, %s %s, сумма на вашем счету составляет: %d\n",
                1231, dataBase.getDb().get(1231).getName(),dataBase.getDb().get(1231).getSurname(), tmp);

        System.out.println();

        // Создание ситуации,при которой у нас блокируется доступ к аккаунту, после чего мы не ждем 5 секунд,
        // а сразу пытаемся его использовать

        System.out.println("Ситуация, когда 3 раза ввели неправильный пинкод и не ждем 5 секунд");

        for (int i = 0; i < 3; i++) {

            tmp = terminal.checkAccount(1231, 1112);
            if (tmp != 0) {

                System.out.println(tmp);

            }
        }

        try {

            terminal.checkAccount(1231, 1111);

        } catch (TerminalException e) {

            System.out.println("AccountIsLockedException has been caught, you must wait for 5 sec");
            Thread.sleep(5000);
        }

        System.out.println();

        //

        // Обращение к методам терминала после того, как ввели пинкод


        System.out.println("Работа с методами после того, как ввели пинкод");
        terminal.checkAccount(1231, 1111);
        System.out.printf("Состояние счета до добавления: %d\n", terminal.checkAccount(1231, 1111));
        terminal.putMoney(1231, 3300);
        System.out.printf("Состояние счета после добавления и до удаления: %d\n", terminal.checkAccount(1231, 1111));
        terminal.getMoney(1231, 3000);
        System.out.printf("Состояние счета после удаления: %d\n", terminal.checkAccount(1231, 1111));
        System.out.println("Счет после всех вычислений " + terminal.checkAccount(1231, 1111));
        System.out.println();


        //

        //  Обращение к методам терминала, не вводя перед этим пинкод


        System.out.println("Работа с методами, не вводя пинкод");
        try {

            terminal.getMoney(1232, 300);

        } catch (NoPinCodeException e2) {

            System.out.println("NoPinCodeException has been caught when getMoney");

        }


        try {

            terminal.putMoney(1232, 300);

        } catch (NoPinCodeException e2) {

            System.out.println("NoPinCodeException has been caught when putMoney");

        }

        System.out.println();

        //

        // Попытка вызова checkAccount без ввода пина

        System.out.println("метод checkAccount без ввода пина");

        try {

            terminal.checkAccount(1233, null);

        } catch (NoPinCodeException e3) {

            System.out.println("NoPinCodeException has been caught");
        }


    }


}
