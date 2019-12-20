package com.example.test.base;


public class TimeTest {
    private static long timeSec = System.currentTimeMillis() / 1000;

    public static void main(String[] args) throws Exception{
        System.out.println(timeSec);
        Thread.sleep(2000);
        System.out.println(timeSec);
    }
}
