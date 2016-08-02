package ru.sbt.bodya.hw4.collectionUtilsTask;

import java.util.Comparator;
import java.util.List;

public class CollectionUtilsTest {

    public static void main(String[] args) {

        // testing newArrayList and addAll

        List<Integer> integerList = CollectionUtils.newArrayList();
        List<Double> doubleList = CollectionUtils.newArrayList();
        List<String> stringList = CollectionUtils.newArrayList();
        List<Number> numberList = CollectionUtils.newArrayList();
        List<Object> objectList = CollectionUtils.newArrayList();

        integerList.add(10);
        integerList.add(20);

        doubleList.add(10d);
        doubleList.add(20d);

        stringList.add("Bodya");
        stringList.add("Maryana");
        stringList.add("Dima");
        stringList.add("Julia");
        stringList.add("Anya");

        CollectionUtils.addAll(integerList, numberList);
        CollectionUtils.addAll(doubleList, numberList);

        System.out.printf("Количество элементов в numberList после добавления элементов из integerList и " +
                "doubleList: %d\n", numberList.size());


        CollectionUtils.addAll(integerList, objectList);
        CollectionUtils.addAll(doubleList, objectList);
        CollectionUtils.addAll(stringList, objectList);
        CollectionUtils.addAll(numberList, objectList);

        System.out.printf("Количество элементов в numberList после добавления элементов из integerList, " +
                "doubleList, stringList и numberList: %d\n", objectList.size());

        System.out.println();

        //

        // testing indexOf

        System.out.println("Индекс элемента " + 20 + " в numberList: " + CollectionUtils.indexOf(numberList, 20));

        System.out.println("Индекс элемента 'bodya' в objectList: " + CollectionUtils.indexOf(objectList, "bodya"));

        System.out.println();

        //

        // testing limit

        List<String> stringList2 = CollectionUtils.limit(stringList, 4);
        for (int i = 0; i < stringList2.size(); i++) {
            System.out.printf("%d-ая строчка в stringList2: %s\n", i, stringList2.get(i));

        }

        System.out.println();

        List<String> stringList3 = CollectionUtils.limit(stringList, 6);
        for (int i = 0; i < stringList3.size(); i++) {
            System.out.printf("%d-ая строчка в stringList2: %s\n", i, stringList3.get(i));

        }

        System.out.println();

        //

        // testing add

        CollectionUtils.add(stringList, "Slava");
        CollectionUtils.add(stringList, "Gleb");

        System.out.printf("Размер stringList после добавления строк: %d\n", stringList.size());

        System.out.println();

        //

        // testing removeAll

        List<String> stringList4 = CollectionUtils.newArrayList();
        stringList4.add("Slava");
        stringList4.add("Anya");
        CollectionUtils.removeAll(stringList, stringList4);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.printf("%d-ая строчка в stringList2 после удаления: %s\n", i, stringList.get(i));

        }

        System.out.println();

        //

        // testing containsAll


        stringList.add("Slava");
        stringList.add("Anya");

        System.out.printf("Все ли элементы stringList4 содержатся в stringList: %b\n",
                CollectionUtils.containsAll(stringList, stringList4));

        stringList4.add("Petr");

        System.out.printf("Все ли элементы stringList4 содержатся в stringList после добавления нового элемента: %b\n",
                CollectionUtils.containsAll(stringList, stringList4));

        System.out.println();

        //

        // testing containsAny


        System.out.printf("Содержится хоть один элемент из stringList4 в stringList: %b\n",
                CollectionUtils.containsAny(stringList, stringList4));

        System.out.printf("Содержится хоть один элемент из doubleList в numberList: %b\n",
                CollectionUtils.containsAny(numberList, doubleList));

        List<Integer> integerList2 = CollectionUtils.newArrayList();
        integerList2.add(30);

        System.out.printf("Содержится хоть один элемент из integerList2 в numberList: %b\n",
                CollectionUtils.containsAny(numberList, integerList2));
        System.out.println();

        //

        // testing range

        integerList2.add(50);
        integerList2.add(10);
        integerList2.add(20);
        integerList2.add(40);

        List<Integer> rangeAnswer1 = CollectionUtils.range(integerList2, 20, 30);
        System.out.printf("Список элементов после выполнения метода range у integerList2\n");
        for (Integer a : rangeAnswer1) {
            System.out.printf("%d ", a);
        }

        //

        // testing range with Comparator

        CollectionUtils.removeAll(integerList2, integerList2);

        integerList2.add(50);
        integerList2.add(10);
        integerList2.add(20);
        integerList2.add(40);
        integerList2.add(30);

        List<Integer> rangeAnswer2 = CollectionUtils.range(integerList2, 20, 30, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1: 1;
            }
        });

        System.out.println();

        System.out.printf("Список элементов после выполнения метода range with Comparator у integerList2\n");
        for (Integer a : rangeAnswer2) {
            System.out.printf("%d ", a);
        }

    }
}
