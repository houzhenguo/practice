package com.example.test.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  测试中断线程
 */
public class ReteenLockTest {
//     ExecutorService service = Executors.newFixedThreadPool(1,r->{
//        Thread thread = new Thread("test");
//       // thread.setDaemon(true);
//        return thread;
//    });

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(1);

        service.submit(()->{
            ReentrantLock lock = new ReentrantLock();
            try {
                Thread.currentThread().interrupt();
                lock.lockInterruptibly();
                int i =0;
                for (;;)
                {
                    i++;
                    Thread.sleep(100L);
                    System.out.println("i is "+i );
                    if(i>10)
                    {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("unlock");
                latch.countDown();
            }
        });

        System.out.println("main wait");
        latch.await();
        System.out.println("main finish");
    }
}
