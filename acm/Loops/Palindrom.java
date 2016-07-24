package Loops;

import java.util.Scanner;

public class Palindrom {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int count = 0;

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {

            array[i] = scanner.nextInt();

        }

        for (int i = 0, j = size - 1; i <= size / 2 && j >= size / 2 ; i++, j--) {

            if (array[i] != array[j]) {

                count++;

            }
        }

        System.out.println(count);

    }

}
