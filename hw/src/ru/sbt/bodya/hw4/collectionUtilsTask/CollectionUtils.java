package ru.sbt.bodya.hw4.collectionUtilsTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {

        destination.addAll(source);

    }

    public static <T> List<T> newArrayList() {

        return new ArrayList<>();

    }


    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }


    public static <T> List<T> limit(List<T> source, int size) {
        return source.size() <= size ? source : source.subList(0, size);
    }


    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }


    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }


    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (Object obj : c2) {
            if (c1.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public static <T> List<T> range(List<T> list, T min, T max) {

        List<T> tmpList = new ArrayList<>(list);

        Collections.sort(tmpList, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        });

        return tmpList.subList(tmpList.indexOf(min), tmpList.indexOf(max) + 1);

    }

    public static <T> List<T> range(List<T> list, T min, T max, Comparator<? super T> comparator) {

        List<T> tmpList = new ArrayList<>(list);
        Collections.sort(tmpList, comparator);
        return tmpList.subList(tmpList.indexOf(min), tmpList.indexOf(max) + 1);

    }

}
