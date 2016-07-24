package Loops;

import java.util.Scanner;

public class RoundNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        int count = 0;

        while (number % 2 == 0) {

            number /= 2;

            count++;

        }

        System.out.println(count);

    }

}
