package ru.sbt.bodya.hw6.beanutils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class BeanUtilsTest {


    public static void main(String[] args) {


        // Создаем FromFactory и ToFactory, затем вызываем метод assign для передачи данных

        FromFactory from = new FromFactory(5, 3.3, new Date(), new Account("Bogdan", "Popov", 500, 2143), "Hello, sbt!",
                76.7f, 'a');

        ToFactory to = new ToFactory(null, null, null, null, null, null, null);

        System.out.println("Значения полей до вызова метода:");
        printFields(to);
        BeanUtils.assign(to, from);
        System.out.println("Значения полей после вызова метода:");
        printFields(to);

        //

        // Тестим все геттеры и сеттеры

        System.out.println("Вывод всех геттеров объекта 'to' с их значениями до присвоения новых значений: ");
        printGetMethods(to);
        to.setObject3(new Date(123000));
        to.setObject4(new Account("Dima", "Povetkin", 400, 2124));
        to.setObject5("hello java School!");
        to.setObject6('u');
        to.setObject7(123.6f);
        System.out.println("Вывод всех геттеров объекта 'to' с их значениями после присвоения новых значений: ");
        printGetMethods(to);


        System.out.println("Вывод всех геттеров объекта 'from' с их значениями до присвоения новых значений: ");
        printGetMethods(from);
        from.setObject1(10);
        from.setObject2(12d);
        from.setObject3(new Date(1230302));
        from.setObject4(new Account("Maryana", "Popova", 400, 2124));
        from.setObject5("hello Maryana!");
        from.setObject6(21.3f);
        from.setObject7('l');
        System.out.println("Вывод всех геттеров объекта 'from' с их значениями после присвоения новых значений: ");
        printGetMethods(from);


    }


    private static void printFields(Object o) {

        for (Field field : o.getClass().getDeclaredFields()) {

            try {
                field.setAccessible(true);
                System.out.println(field.get(o));
                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
                ;
            }

        }
        System.out.println();

    }

    private static void printGetMethods(Object o) {

        for (Method method : o.getClass().getMethods()) {

            if (method.getName().startsWith("getO")) {

                try {
                    System.out.println(method.getName() + ": " + method.invoke(o));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println(e.getMessage());
                }

            }

        }

        System.out.println();

    }
}
