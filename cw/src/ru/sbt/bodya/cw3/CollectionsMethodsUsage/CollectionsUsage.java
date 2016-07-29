package ru.sbt.bodya.cw3.CollectionsMethodsUsage;

import java.util.*;

public class CollectionsUsage {


    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 5, 3, 2, 4, 5);
        Integer max = Collections.max(integers);


        Integer maxx = Collections.max(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });

        Integer maxxx = Collections.max(integers, (o1, o2) -> -1 * o1.compareTo(o2));


        Map<Integer, Integer> map = new HashMap<>();
        int maxKey = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

    }
}
