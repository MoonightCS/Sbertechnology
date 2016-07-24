package Arrays;

import java.util.Scanner;

public class MinZapros {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size, count, min, first, second;

        size = scanner.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {

            array[i] = scanner.nextInt();

        }

        count = scanner.nextInt();

        for (int i = 0; i < count; i++) {

            min = 101;

            first = scanner.nextInt();

            second = scanner.nextInt();

            for (int j = first - 1; j < second; j++) {

                if (array[j] < min) {

                    min = array[j];

                }

            }

            System.out.println(min);

        }

    }

}
