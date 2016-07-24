package Loops;

import java.util.Scanner;

public class Gcd {

    private static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();

        int second = scanner.nextInt();

        int answer = gcd(first, second);

        System.out.printf("%d %d", count, answer);

    }

    public static int gcd(int a, int b) {

        if (b == 0)
            return a;
        else
            return gcd(b, rem(a, b));

    }

    private static int rem (int a, int b) {

        if (a < b) {

            return a;

        }

        else {

            count += (a / b);
            return a % b;

        }

    }

}
