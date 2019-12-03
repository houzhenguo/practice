package com.example.test.collection;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("a");
        treeSet.add("a");
        System.out.println(treeSet.size());

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");

        TreeMap<String, String> map = new TreeMap<>();
        map.put("a","c");
    }

}
