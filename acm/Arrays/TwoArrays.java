package Arrays;

import java.util.Scanner;

public class TwoArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sizeA, sizeB, count = 0;

        sizeA = scanner.nextInt();

        int[] arrayA = new int[sizeA];

        int[] answer = new int[sizeA];

        for (int i = 0; i < sizeA; i++) {

            arrayA[i] = scanner.nextInt();

        }

        sizeB = scanner.nextInt();

        int[] arrayB = new int[sizeB];

        for (int i = 0; i < sizeB; i++) {

            arrayB[i] = scanner.nextInt();

        }

        for (int i = 0; i < sizeA; i++) {

            for (int j = 0; j < sizeB; j++) {

                if (arrayA[i] == arrayB[j]) {

                    answer[count++] = arrayA[i];

                    break;

                }

            }

        }

        System.out.println(count);

        for (int i = 0; i < count; i++) {

            System.out.printf("%d ", answer[i]);

        }


    }

}
