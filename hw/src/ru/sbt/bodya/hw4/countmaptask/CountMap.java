package ru.sbt.bodya.hw4.countmaptask;

import java.util.Map;

public interface CountMap<E> {

    int getCount(E o);

    int remove(E o);

    int size();

    void toMap(Map<? super E, Integer> destination);

    void add(E o);

    void addAll(CountMap<? extends E> map);

    Map<E, Integer> toMap();

}
