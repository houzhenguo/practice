package com.example.test.other;

public class RunTimeProcessorTest {
    public static void main(String[] args) {
        int size = Runtime.getRuntime().availableProcessors();
        System.out.println(size);
    }
}
