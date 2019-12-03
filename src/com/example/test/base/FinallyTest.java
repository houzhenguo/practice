package com.example.test.base;

public class FinallyTest {

    public static void main(String[] args) {
        System.out.println(test());
    }
    public static boolean test() {
        try {
            return false;
        }catch (Exception e) {

        }finally {
            return true;
        }
    }
}
