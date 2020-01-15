package com.example.test.juc;

import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) throws Exception {
//        ExecutorService executor = new ThreadPoolExecutor(1
//                , 1
//                , 30
//                , TimeUnit.SECONDS
//                , new ArrayBlockingQueue<>(5), new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r,"mythread");
//            }
//        });
//
//        Future future = executor.submit(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"__");
//        });

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "say helloWorld!!!";
            }
        });
        System.out.println(future.get());// 通过get返回结果

    }
}
