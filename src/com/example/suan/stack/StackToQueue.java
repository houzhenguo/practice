package com.example.suan.stack;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
// 使用两个 栈 实现 队列 。来回倒腾
public class StackToQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push("你");
        queue.push("好");
        queue.push("啊");
        System.out.println(queue.pull());
        System.out.println(queue.pull());
    }
}
class MyQueue {
    // 用栈实现队列
    private Stack<String> stack1 = new Stack<>();
    private Stack<String> stack2 = new Stack<>();
    // push E to queue
    // pop remove
    public void push(String e) {
        if(stack1.size() != 0) {
            stack1.push(e);
        }else if(stack2.size() != 0){
            stack2.push(e);
        }else {
            stack1.push(e);
        }

    }
    // pull 从队列中出队
    public String pull() {
        if(stack1.size() >0 && stack2.size() == 0) {
            String s = "";
            while (stack1.size() != 0) {
                s = stack1.pop();
                if (stack1.size() >0) {
                    stack2.push(s);
                }

            }
            while (stack2.size() > 0 && stack1.size() == 0) {
                while (stack2.size() > 0) {
                    stack1.push(stack2.pop());
                }
            }
            return s;
        }
        return null;
    }
}

