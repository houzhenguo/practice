package com.example.suan.test;

public class BitTest {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1255));
        System.out.println(test(1255,4));
        System.out.println(Integer.toBinaryString(1255^1));
        System.out.println(Integer.toBinaryString(1255|(1<<4)));
    }

    public static boolean test(int a, int index) {
        int b = 1 <<(index-1);
        return (a & b) ==b;
    }

}


