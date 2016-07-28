package Loops;

import java.util.Arrays;
import java.util.Scanner;

public class EratosthenesSieve {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt() + 1;
        boolean[] array = new boolean[n];
        fillSieve(array);
        for (int i = 0; i < n; i++) {

            if (array[i]) {

                System.out.println(i);

            }

        }

    }

    private static void fillSieve(boolean[] primes) {

        Arrays.fill(primes, true);

        primes[0] = false;

        if (primes.length > 1) {

            primes[1] = false;

        }

        for (int i = 2; i < primes.length; i++) {

            if (primes[i]) {

                for (int j = 2; i * j < primes.length; j++) {

                    primes[i * j] = false;

                }
            }
        }
    }

}
