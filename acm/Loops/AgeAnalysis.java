package Loops;

import java.util.Scanner;

//Если это число меньше 7, то обычно это обозначает, что задан дошкольник и надо вывести "preschool child".
//        Если это число от 7 до 17, то обычно это обозначает, что задан школьник и надо вывести "schoolchild m", где m — это его предполагаемый класс (число от 1 до 11, считайте, что учатся в школе с 7 лет, класс меняется раз в год).
//        Если это число от 18 до 22, то обычно это обозначает, что задан студент и надо вывести "student m", где m — это его предполагаемый курс (число от 1 до 5, считайте, что учатся в университете с 18 лет, курс меняется раз в год).
//        Если это число больше 22, то выведите "specialist", что обозначает квалификацию "специалист".


public class AgeAnalysis {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int course;

        int age = scanner.nextInt();

        if (age < 7) {

            System.out.println("preschool child");

        } else {

            if (age <= 17) {

                course = age - 6;

                System.out.printf("schoolchild %d", course);

            } else {

                if (age <= 22) {

                    course = age - 17;

                    System.out.printf("student %d", course);

                } else {

                    System.out.println("specialist");

                }

            }

        }

    }

}
