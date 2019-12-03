package com.example.test.juc;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactoryTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,60, TimeUnit.SECONDS
        , new LinkedBlockingDeque<>(), r -> {
            Thread t = new Thread(r);
            t.setName("aaa");
            return t;
        });
    }
}
