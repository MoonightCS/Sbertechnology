package Strings;

import java.util.Scanner;

public class StrangeWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int count = 0, flag = 0, length;

        String tmp;

        char[] array;

        for (int i = 0; i < size; i++) {

            tmp = scanner.next();

            array = tmp.toCharArray();

            length = array.length;

            for (int j = 0; j < length && flag == 0; j++) {

                char c = array[j];

                if ((c == 'e') || (c == 'y') || (c == 'u') ||
                        (c == 'i') || (c == 'o') || c == 'a') {

                    count++;

                    if (count >= 3) {

                        flag = 1;

                    }

                } else {

                    count = 0;

                }

            }

            if (flag == 0) {

                System.out.println(tmp);

            }

            count = 0;
            flag = 0;

        }

    }

}
