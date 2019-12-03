package com.example.test.collection;

import java.util.SortedMap;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(3, "3i");
        map.put(1, "1i");
        map.put(6, "6i");
        map.put(4, "4i");
        map.put(9, "9i");
        SortedMap sortedMap = map.tailMap(5);
        map.headMap(2);
        sortedMap.values().forEach(System.out::println); // 输出比5大的

    }
}
