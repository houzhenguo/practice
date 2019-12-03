package com.example.test.juc;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    static ThreadPoolExecutor executor;
    static {
        executor = new ThreadPoolExecutor(2
                , 2
                , 60
                , TimeUnit.SECONDS, new LinkedBlockingDeque<>(10)
                , r -> {return new Thread(r,"test-thread");});
    }
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        //ReentrantLock lock1 = new ReentrantLock();
        executor.execute(()->{
            System.out.println("wait lock" + Thread.currentThread().getName());
            lock.lock();

            System.out.println("get lock" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("release lock");
                lock.unlock();
            }

        });
        executor.execute(()->{
            System.out.println("wait lock" + Thread.currentThread().getName());
            lock.lock();
            System.out.println("get lock" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("release lock" + Thread.currentThread().getName());
                lock.unlock();
            }

        });
    }
}
