package Strings;

import java.util.*;

//Данное решение проходит все тесты

public class MostPopularWordAnother {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeSet<String> treeSet = new TreeSet<>();
        int max = 0;
        Map<String, Integer> map = new HashMap<>();

        while (scanner.hasNext()) {

            String s = scanner.next().toLowerCase();
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
