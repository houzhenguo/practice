package com.example.test.generic;

import java.io.Serializable;

public class ExtendsTest {
    public static void main(String ... args) {
        Integer[] nums = {9,2,4,8,3};
        Integer min = min(nums);
        System.out.println(min);

        String[] strings = {"c", "a", "b"};
        String minS = min(strings);
        System.out.println(minS);
    }
    // 泛型方法的使用
    public static <T extends Comparable & Serializable> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        for (int i=1; i<a.length; i++) {
            if (a[i].compareTo(min) <0) {
                min = a[i];
            }
        }
        return min;
    }
}
