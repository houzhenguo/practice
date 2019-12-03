package com.example.workpractice;

public class RTest1 {
    public static void main(String[] args) {
        System.setProperty("a", "c");
        System.out.println(System.getProperty("a1", "mm"));
    }
}
