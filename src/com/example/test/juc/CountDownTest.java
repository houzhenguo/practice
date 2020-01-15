package com.example.test.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Test 所有的线程等待 某个事件完成
 */
public class CountDownTest {
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(1);
        service.execute(()->{
            try {
                Thread.sleep(5000);
                latch.countDown();
                System.out.println("测试是否阻塞");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.execute(()->{
            try {
                latch.await();
                System.out.println("任务开始执行1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.execute(()->{
            try {
                latch.await();
                System.out.println("任务开始执行2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
