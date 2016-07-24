package Arrays;

import java.util.Scanner;

public class DividingСouples{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int count = 0;

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {

            array[i] = scanner.nextInt();

        }

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (array[i] % array[j] == 0 && j != i) {

                    count++;

                }

            }

        }

        System.out.println(count);

    }
}
