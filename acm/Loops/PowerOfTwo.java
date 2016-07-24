package Loops;

import java.util.Scanner;

public class PowerOfTwo {

    public static void main(String[] args) {

        int n, power = 1, answer = 0;

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {

            if (i == power) {

                answer += scanner.nextInt();

                power *= 2;

            } else {

                scanner.nextInt();

            }

        }

        System.out.println(answer);

    }

}
