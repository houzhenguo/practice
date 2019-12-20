package com.example.suan.other;

import java.util.HashMap;
import java.util.Map;

// LRU 手动实现 (没有经过测试版本)
public class LRU {
    private Map<Integer, DLinkedNode> cache ;
    private int count;
    private int capacity;
    DLinkedNode head,tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        this.head = new DLinkedNode();
        this.head.pre = null;
        this.tail = new DLinkedNode();
        this.tail.next = null;
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    private void moveToHead(DLinkedNode node) {
        // 摘除节点
        node.next.pre = node.pre;
        node.pre.next = node.next;
        addNode(node);
    }
    private void addNode(DLinkedNode node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int put(int key, int val) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode();
            node.key = key;
            node.value = val;
            moveToHead(node);
            ++count;
            if (count > capacity) {             // 注意这个地方
                DLinkedNode last = tail.pre;
                last.pre.next = tail;
                tail.pre = last.pre;
                if (last != null) {
                    cache.remove(last.key);
                    last = null;
                    --count;
                }
            }
        }else {
            node.value = val;
            moveToHead(node);
        }
        return node.value;
    }
}

class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
}