package com.example.suan.other;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCModelTest {
    // 生产者消费者模型 练习
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3); // 注意必须限制长度
        new Thread(new Producer<>(queue), "thread1").start();
        new Thread(new Consumer<>(queue), "thread2").start();
    }

}
class Producer<T> implements Runnable{
    BlockingQueue<T> queue;
    int count = 0;
    public Producer(BlockingQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.put((T)("count" +(++count))); // put 会阻塞
            }catch (Exception e) {

            }
        }
    }
}
class Consumer<T> implements Runnable {
    BlockingQueue<T> queue;
    public Consumer(BlockingQueue<T> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                T t = queue.take(); // take 会阻塞
                System.out.println(t);
            }catch (Exception e) {

            }
        }
    }
}
