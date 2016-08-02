package ru.sbt.bodya.hw4.countMaptask;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<E> implements CountMap<E> {


    private final Map<E, Integer> map;


    public CountMapImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public void add(E o) {
        map.put(o, !map.containsKey(o) ? 1 : map.get(o) + 1);
    }

    @Override
    public int getCount(E o) {
        return map.containsKey(o) ? map.get(o) : 0;
    }

    @Override
    public int remove(E o) {
        Integer answer = map.remove(o);
        return answer == null ? 0 : answer;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public <T extends E> void addAll(CountMap<T> secondMap) {
        for (Map.Entry<T, Integer> e : secondMap.toMap().entrySet()) {
            for (int i = 0; i < secondMap.getCount(e.getKey()); i++) {
                this.add(e.getKey());

            }
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        return this.map;
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        for (E key : this.toMap().keySet()) {

            destination.put(key, this.getCount(key));

        }
    }


}