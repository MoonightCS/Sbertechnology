package Loops;

import java.util.Scanner;

public class CutSquare {

    public static void main(String[] args) {

        int a1, a2, b1, b2;

        Scanner scanner = new Scanner(System.in);

        a1 = scanner.nextInt();

        b1 = scanner.nextInt();

        a2 = scanner.nextInt();

        b2 = scanner.nextInt();

        if ( ((a1 + a2) == b1 && (b1 == b2)) || ((a1 + b2) == b1 && (b1 == a2)) || ((a2 + b1) == a1 &&
                (a1 == b2)) || ((b1 + b2) == a1 && (a1 == a2))) {

            System.out.println("YES");

        } else {

            System.out.println("NO");

        }

    }

}
