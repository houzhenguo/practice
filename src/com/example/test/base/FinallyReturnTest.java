package com.example.test.base;

public class FinallyReturnTest {
    public static int aaa() {
        int x = 1;

        try {
            return ++x;
        } catch (Exception e) {

        } finally {
           return  ++x;
        }
       // return x;
    }

    public static void main(String[] args) {
        FinallyReturnTest t = new FinallyReturnTest();
        int y = FinallyReturnTest.aaa();
        System.out.println(y);
    }
}
