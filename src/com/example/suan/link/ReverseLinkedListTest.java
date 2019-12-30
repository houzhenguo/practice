package com.example.suan.link;

import java.util.ArrayList;
import java.util.List;

// 链表反转 专题
public class ReverseLinkedListTest {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        Node head = buildLinkedList(arr);
//        Node newHead = reverse1(head);
//        List<Integer> result = getListVal(newHead);
//        result.forEach(System.out::println);
//        Node newHead = reverseGroup(head,3);
//        List<Integer> result = getListVal(newHead);
        //result.forEach(System.out::println);
        // 1 2 5 4 3 8 7 6
        Node head1 = reverse(head);
        Node head2 = reverseGroup(head1, 3);
        Node head3 = reverse(head2);
        List<Integer> result1 = getListVal(head3);
        result1.forEach(System.out::println);

    }


    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    //
    public static Node buildLinkedList(int[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node pre = head;
        for (int i =1;i<arr.length;i++) {
            Node node = new Node(arr[i]);
            pre.next = node;
            pre = pre.next;
        }
        return head;
    }
    public static List<Integer> getListVal(Node head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    // 递归方式的逆序
    public static Node reverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        Node newHead = reverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    // 使用非递归的方式进行反转
    public static Node reverse1(Node head) {
        Node next   = null; // 指向当前节点的后驱
        Node pre    = null; // 指向当前节点的前驱
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 每隔 K 个节点进行一次反转
    public static Node reverseGroup(Node head, int k) {
        Node temp = head; // temp 下一波的节点
        int k1 = k;
        while(--k1 > 0 && temp != null) {
            temp = temp.next;
        }
        if(temp == null) { // 说明剩下的已经不足 k 个节点，直接接上即可
            return head;
        }
        Node t2 = temp.next;
        temp.next = null; // 断开连接
        Node newHead = reverse(head);
        head.next = reverseGroup(t2, k); // 这时候 head 已经是前一个分组的 尾部了
        return newHead;
    }




}
