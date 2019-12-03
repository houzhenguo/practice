package com.example.test.generic;

public class PairTest {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>();
        pair.setFirst("hello");
        pair.setSecond(1);
        System.out.println(pair.toString());

        String test = PairTest.<String>getMiddle("aaa");
        System.out.println(test);
    }
    public static <T> T getMiddle(T a) {
        return a;
    }
}
