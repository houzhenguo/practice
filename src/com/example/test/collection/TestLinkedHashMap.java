package com.example.test.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class TestLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(2,"b");
        map.put(2,"b1");
        map.put(1,"a");
        map.put(3,"c");
        map.forEach((k, v)->{
            System.out.println(k+" and "+ v);
        });

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(2,"b");
        map1.put(2,"b1");
        map1.put(1,"a");
        map1.put(3,"c");
        map1.forEach((k, v)->{
            System.out.println(k+" and "+ v);
        });
    }
}
