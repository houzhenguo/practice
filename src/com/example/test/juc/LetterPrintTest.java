package com.example.test.juc;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// 交替打印 26个字母 65A - 97a
public class LetterPrintTest {
    public static void main(String[] args) {
        Object lock = new Object();
        AtomicInteger count = new AtomicInteger(65);
        new Thread(new Task(lock, count),"thread1").start();
        new Thread(new Task(lock, count),"thread2").start();
    }
    // 开辟两个线程交替打印 26个字母
    // 直接手写线程吧，不使用线程池了
    static class Task implements Runnable {
        Object lock;
        AtomicInteger count;
        @Override
        public void run() {
            while (true && count.get() < 91) { // 注意不要越界
                synchronized (lock) { // 注意锁这里
                    lock.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "__" + (char)count.getAndIncrement());
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        public Task(Object lock, AtomicInteger count) {
            this.lock = lock;
            this.count = count;
        }
    }
}
