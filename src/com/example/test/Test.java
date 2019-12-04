package com.example.test;

import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        System.out.println(1/0);
    }
}
