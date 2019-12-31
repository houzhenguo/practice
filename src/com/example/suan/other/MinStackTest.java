package com.example.suan.other;

import java.util.Stack;

public class MinStackTest {
    // min 栈
    public static void main(String[] args) {

    }
    public Stack<Integer> dataStack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (!minStack.isEmpty()) {
            if (node <= minStack.peek()) {
                minStack.push(node);
            }
        }else {
            minStack.push(node);
        }
    }

    public void pop() {
        if(minStack.peek() == dataStack.pop()){
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
