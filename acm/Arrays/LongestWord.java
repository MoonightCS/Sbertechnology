package Arrays;

import java.util.Scanner;

public class LongestWord {


    public static void main(String[] args) {

        String str;

        Scanner scanner = new Scanner(System.in);

        str = scanner.nextLine();

        System.out.println(analysis(str));

    }

    private static int analysis(String str) {

        int count = 0, code, max = 0;

        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            code = (int) arr[i];

            if ((code >= 65 && code <= 90) || (code >= 97 && code <= 122)) {

                count++;

            } else {

                if (count > max) {

                    max = count;

                }

                count = 0;

            }

        }

        return max;

    }

}
