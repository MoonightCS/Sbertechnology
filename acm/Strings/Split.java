package Strings;

import java.util.Scanner;

public class Split {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] array;

        String s = scanner.next();

        StringBuilder stringBuilder = new StringBuilder();

        int k = scanner.nextInt();

        int count = 0, len;

        char[] ch = s.toCharArray();

        for (int i = 0; k == 0 && i < ch.length; i++) {

            if (ch[i] == ',') {

                count++;

            }

        }

        array = s.split(",");

        len = array.length;

        for (int i = 0; i < len; i++) {

            if (array[i].length() >= k) {

                stringBuilder.append(array[i]);
                stringBuilder.append(',');

            }

        }

        for (int i = 0; k == 0 && i <= count - array.length; i++) {

            stringBuilder.append(',');

        }

        len = stringBuilder.length() - 1;

        if (stringBuilder.charAt(len) == ',') {

            stringBuilder.deleteCharAt(len);

        }

        System.out.println(stringBuilder);
    }
}
