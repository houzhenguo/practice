package com.example.suan;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Foo {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.add("aa");
        q.add("bb");
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }


}
