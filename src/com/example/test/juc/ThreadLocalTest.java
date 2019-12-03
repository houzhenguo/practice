package com.example.test.juc;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Integer> local  = new ThreadLocal<>();
        local.remove();
    }
}
