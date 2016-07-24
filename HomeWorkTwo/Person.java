package ru.sbt.bodya.hw;

public class Person {

    private final boolean man;

    private final String name;

    private Person spouse;


    public Person(boolean man, String name) {

        this.man = man;

        this.name = name;

        this.spouse = null;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * <p>
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */


    public boolean marry(Person person) {

        if (person.man != this.man && this.spouse != person) {

            if (this.spouse != null) {
                this.divorce();
            }

            if (person.spouse != null) {
                person.divorce();
            }
            this.spouse = person;
            person.spouse = this;
            return true;

        } else {

            return false;

        }

    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */

    public boolean divorce() {

        if (this.spouse != null) {

            this.spouse.spouse = null;
            this.spouse = null;
            return true;

        } else {
            return false;
        }

    }


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

        if (man1.spouse != null) {
            System.out.printf("man1 wife = %s\n", man1.spouse.name);
        }
        if (woman1.spouse != null) {
            System.out.printf("woman1 husband = %s\n", woman1.spouse.name);
        }
        if (man2.spouse != null) {
            System.out.printf("man2 wife = %s\n", man2.spouse.name);
        }
        if (woman2.spouse != null) {
            System.out.printf("woman2 husband = %s\n", woman2.spouse.name);
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
