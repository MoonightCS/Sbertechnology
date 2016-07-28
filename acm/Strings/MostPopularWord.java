package Strings;

import java.util.*;

//Данное решение проходит не все тесты

public class MostPopularWord {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeSet<String> treeSet = new TreeSet<>();
        int max = 0;
        StringBuilder sb = new StringBuilder("");

        while (scanner.hasNext()) {

            sb.append(scanner.nextLine());
            sb.append(" ");

        }

        String[] array = sb.toString().toLowerCase().split("\\s");

        Map<String, Integer> map = new HashMap<>();

        for (String s : array) {

            Integer count = map.get(s);
            if (count == null) {
                count = 0;
            }
            map.put(s, ++count);

        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > max) {

                treeSet = new TreeSet<>();
                max = entry.getValue();
                treeSet.add(entry.getKey());

            } else if (entry.getValue() == max) {

                treeSet.add(entry.getKey());

            }
        }

        for (String s : treeSet) {

            System.out.println(s);

        }

    }
}
