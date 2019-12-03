package com.example.test.base;

public class IntegerTest {
    public static void main(String[] args) {
//        Integer a = Integer.valueOf(128);
//        Integer b = Integer.valueOf(55);
//        Integer c = Integer.valueOf(128);
//        Integer d = Integer.valueOf(55);
//        System.out.println(a==c);
//        System.out.println(b == d);
//        System.out.println(Math.round(2.6));
        Integer a = 0;
        test(a);
        System.out.println(a);
    }

    public static void test(Integer a) {
        a = a+1;
    }
}
