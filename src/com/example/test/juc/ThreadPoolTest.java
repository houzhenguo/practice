package com.example.test.juc;

import java.util.concurrent.*;

public class ThreadPoolTest {
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS
            , new LinkedBlockingDeque<>(20)
            , r -> new Thread(r,"myThread"));
    static ScheduledThreadPoolExecutor service = new ScheduledThreadPoolExecutor(1, r -> {
        Thread t = new Thread(r,"delay-thread"); // 注意，这个 r 非常重要，否则无法输出。
        return t;
    });


    public static void main(String[] args) {
        execute(()->{
            System.out.println("test"+ Thread.currentThread().getName());
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        delay(()->{
            System.out.println("delay time" + Thread.currentThread().getName());
        }, 4);
        // 测试 Callable
        String res = call(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000L);
                return "aaa";
            }
        });
        System.out.println("hahha");
        System.out.println("result is "+ res);

    }
    // 立即执行
    public static void execute(Runnable task) {
        executor.execute(task);
    }

    // 延迟执行
    public static void delay(Runnable runnable, long delayTime) {
        if (delayTime <= 0) {
            service.execute(runnable);
        }else {
            service.schedule(runnable, delayTime, TimeUnit.SECONDS);
        }
    }

    public static <T> T  call(Callable<T> callable) {
        try {
            Future<T> future = executor.submit(callable);
            T res = future.get();
            return res;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
