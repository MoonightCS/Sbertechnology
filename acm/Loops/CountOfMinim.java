package Loops;

import java.util.Scanner;

public class CountOfMinim {

    public static void main(String[] args) {

        int tmp, n, count = 0, min = 10001;

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            tmp = scanner.nextInt();

            if (tmp <= min) {

                if (tmp == min) {

                    count++;

                } else {

                    min = tmp;

                    count = 1;

                }

            }

        }

        System.out.println(count);

    }

}
