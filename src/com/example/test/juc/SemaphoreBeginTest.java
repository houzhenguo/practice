package com.example.test.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *  使用信号量 阻塞等待
 */
public class SemaphoreBeginTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newScheduledThreadPool(5);
        Semaphore semaphore = new Semaphore(6); // 一共有 6 个许可证
        service.execute(()->{
            try {
                semaphore.acquire(5); // 它自己就独占了 5个
                System.out.println("1 获得 5个许可");
                Thread.sleep(4000L);
                semaphore.release(5); // 释放 许可
                System.out.println("1 释放 5个许可");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.execute(()->{
            try {
                semaphore.acquire();
                System.out.println("我能拿到一个许可"); // 一共有6个许可，被前面老哥拿了5个，我还能抢到 1个
                Thread.sleep(10000L);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.execute(()->{
            try {
                semaphore.acquire();
                System.out.println("我获得了许可222"); // 终于等那 5个的老哥释放许可了
                semaphore.release(); // finally?
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.execute(()->{
            try {
                semaphore.acquire();
                System.out.println("我获得了许可111"); // 同上
                semaphore.release(); // finally?
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
