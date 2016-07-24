package Loops;

import java.util.Scanner;

public class Index {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int count = scanner.nextInt();

        int tmp, index = 0, min = 10001;

        for (int i = 1; i <= count; i++) {

            tmp = scanner.nextInt();

            if (tmp < min) {

                min = tmp;

                index = i;

            }

        }

        System.out.println(index);

    }

}
