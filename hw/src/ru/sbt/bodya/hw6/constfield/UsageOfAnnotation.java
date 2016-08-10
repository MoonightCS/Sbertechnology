package ru.sbt.bodya.hw6.constfield;

import java.lang.reflect.Field;

public class UsageOfAnnotation {

    // Программа упадет в рантайме, если само поле не uppercase, а также если название поля не совпадает с его значением

    @ValidName
    public static final String MONDAY = "MONDAY";
    @ValidName
    public static final String TUESDAY = "TUESDAY";
    @ValidName
    public static final String WEDNESDAY = "WEDNESDAY";
    @ValidName
    public static final String THURSDAY = "THURSDAY";
    @ValidName
    public static final String FRIDAY = "FRIDAY";
    @ValidName
    public static final String SATURDAY = "SATURDAY";
    @ValidName
    public static final String SUNDAY = "SUNDAY";


    public void validateAllConstField(Object o) {

        Class<?> clazz = o.getClass();

        for (Field field : clazz.getFields()) {

            validateField(o, field);
            System.out.println(field.getName());

        }

    }

    private void validateField(Object o, Field field) {

        if (field.isAnnotationPresent(ValidName.class)) {

            try {

                String tmpName = field.getName().toUpperCase();

                if (!tmpName.equals(field.getName())) {

                    throw new IllegalStateException("name of static final field must be uppercase");

                }

                String value = field.get(o).toString();


                if (!value.equals(field.getName())) {

                    throw new IllegalStateException("Names of the static const field and its value must be equal!");

                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }


        }

    }

    public static void main(String[] args) {


        UsageOfAnnotation usageOfAnnotation = new UsageOfAnnotation();

        usageOfAnnotation.validateAllConstField(usageOfAnnotation);

    }

}