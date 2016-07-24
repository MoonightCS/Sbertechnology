package Loops;

import java.util.Scanner;

public class Truck {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n, weight, capacity = 0, tmp, count = 0;

        n = scanner.nextInt();

        weight = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            tmp = scanner.nextInt();

            if (capacity + tmp <= weight) {

                capacity += tmp;

                count++;

            }

        }

        System.out.printf("%d %d", count, capacity);

    }

}
