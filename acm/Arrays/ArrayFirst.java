package Arrays;

import java.util.Scanner;

public class ArrayFirst {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        int max1 = 0, max2 = 0, flag = 0, quotient;

        int[] array = new int[count];

        for (int i = 0; i < count; i++) {

            array[i] = scanner.nextInt();

            if (array[i] > max1) {

                max2 = max1;

                max1 = array[i];

            }

            else {

                if (max2 < array[i] && array[i] != max1) {

                    max2 = array[i];

                }

            }

        }

        quotient = max1 / 2;

        if (quotient >= max2) {

            if (quotient == max2) {

                flag = 2;

            }

            else {

                flag = 1;

            }

        }

        for (int i = 0; i < count; i++) {

            if (array[i] == max1) {

                if (flag >= 1) {

                    array[i] /= 4;

                }

                else {

                    array[i] /= 2;

                }

                continue;
            }

            if (array[i] == max2 && (flag == 2 || flag == 0)) {

                array[i] /= 2;

            }

        }

        for (int i = 0; i < count; i++) {

            System.out.printf("%d ", array[i]);

        }

    }

}
