package ru.sbt.bodya.hw2;

public class TestPerson {

    public static void main(String[] args) {

        Person man1 = new Person(true, "Bogdan");
        Person woman1 = new Person(false, "Katya");
        Person man2 = new Person(true, "Petya");
        Person woman2 = new Person(false, "Lena");

        man1.marry(woman1);
        man2.marry(woman2);
        man1.marry(woman2);
        man2.marry(woman1);
        man2.divorce();

        if (man1.getSpouse() != null) {
            System.out.printf("man1 wife = %s\n", man1.getSpouse().getName());
        }
        if (woman1.getSpouse() != null) {
            System.out.printf("woman1 husband = %s\n", woman1.getSpouse().getName());
        }
        if (man2.getSpouse() != null) {
            System.out.printf("man2 wife = %s\n", man2.getSpouse().getName());
        }
        if (woman2.getSpouse() != null) {
            System.out.printf("woman2 husband = %s\n", woman2.getSpouse().getName());
        }

        if (man1.marry(woman2) == false) {
            System.out.println("False в методе marry рабоатет");
        }

        if (man2.marry(man1) == false) {
            System.out.println("False в методе marry работает");
        }

        if (man2.divorce() == false) {
            System.out.println("False в методе divorce работает");
        }
    }
}
