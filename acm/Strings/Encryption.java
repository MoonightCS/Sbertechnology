package Strings;

import java.util.*;

public class Encryption {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = 1;

        Map<String, Integer> map = new LinkedHashMap<>();


        while (scanner.hasNext()) {

            String s = scanner.next().toLowerCase();

            if (map.containsKey(s)) {

                System.out.printf("%d ", map.get(s));

            } else {

                map.put(s, count);
                System.out.printf("%d ", count);
                count++;

            }

        }

    }

}
