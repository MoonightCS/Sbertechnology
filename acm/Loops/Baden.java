package Loops;

import java.util.Scanner;

public class Baden {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        double d, f;

        f = (number / 36);

        d = (number % 36);
        d = Math.round(d / 3);

        System.out.printf("%.0f %.0f \n", f, d);

    }

}
