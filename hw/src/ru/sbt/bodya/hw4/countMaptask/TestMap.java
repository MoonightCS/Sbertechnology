package ru.sbt.bodya.hw4.countMaptask;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {

        // testing map.add

        CountMapImpl<Integer> map = new CountMapImpl<>();
        CountMapImpl<Integer> map2 = new CountMapImpl<>();

        map.add(1);
        map.add(2);
        map.add(3);
        map.add(3);

        System.out.println("Количество элементов с ключами 1, 2, 3, 4");
        System.out.println(map.getCount(1));
        System.out.println(map.getCount(2));
        System.out.println(map.getCount(3));
        System.out.println(map.getCount(4));
        System.out.println();

        //

        // testing map.addAll(map2)

        map2.add(1);
        map2.add(2);
        map2.add(3);
        map2.add(4);


        map.addAll(map2);

        System.out.println("Количество элементов с ключами 1, 2, 3, 4 после добалвения новых элементов");
        System.out.println(map.getCount(1));
        System.out.println(map.getCount(2));
        System.out.println(map.getCount(3));
        System.out.println(map.getCount(4));

        //


        // testing addAll with different types

        CountMap<String> map3 = new CountMapImpl<>();
        CountMap<Object> objects = new CountMapImpl<>();

        map3.add("One");
        map3.add("Two");
        map3.add("Three");
        map3.add("Four");


        objects.addAll(map3);
        objects.addAll(map);

        System.out.printf("\nКоличество различных элементов в objects: %d \n", objects.size());

        for (Map.Entry<Object, Integer> object : objects.toMap().entrySet()) {
            System.out.println("Ключ: " + object.getKey() + "; Количество элементов: " + object.getValue());
        }
        System.out.println();


        //


        // testing toMap(map Destination)


        Map<Object, Integer> testMap = new HashMap<>();
        objects.toMap(testMap);

        System.out.printf("Количество различных элементов в testMap после выполнения метода toMap()\n");

        for (Map.Entry<Object, Integer> object : testMap.entrySet()) {
            System.out.println("Ключ: " + object.getKey() + "; Количество элементов: " + object.getValue());
        }
        System.out.println();


        //


        // testing map.remove

        testMap.remove(1);
        testMap.remove("Two");

        System.out.printf("Количество различных элементов в testMap после выполнения метода remove\n");
        for (Map.Entry<Object, Integer> object : testMap.entrySet()) {
            System.out.println("Ключ: " + object.getKey() + "; Количество элементов: " + object.getValue());
        }


    }

}
