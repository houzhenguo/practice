package com.example.test.collection;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put(null,"s");
        map.put(null,"a");
        map.values().forEach(System.out::println);
    }
}
