package com.example.suan.other;

public class SingletonTest {
    private static volatile SingletonTest INSTNCE;
    public static SingletonTest getInstance() {
        if (INSTNCE == null) {
            synchronized (SingletonTest.class) {
                if (INSTNCE == null) {
                    INSTNCE = new SingletonTest(); // double check
                }
            }
        }
        return INSTNCE;
    }
}
