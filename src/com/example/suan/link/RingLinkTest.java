package com.example.suan.link;

public class RingLinkTest {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        boolean flag = ring(build(arr));
        System.out.println(flag);
    }
    // answer
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast.next.next; // 每一轮快两倍
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }while(fast != null); // 注意这里，否则退不出循环,当快的next为null时候，跳出
        return false;
    }
    public static boolean ring(ListNode head) {
        // 思路分析 fast slow pointer
        int count = 0;
        if (head == null || head .next == null) {
            return false;
        }
        ListNode fast = head; ListNode slow = head;
        do{
            fast = fast.next.next;
            slow = slow.next;
        }while (fast != slow && count<10000);
        return true && count<10000;
    }
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    // 构造一个环形链表 {1,2,3,4,5,6,7,8,9->5}
    public static ListNode build(int arr[]) {
        ListNode head = null;
        ListNode pre = null;
        ListNode last = null;
        ListNode rinNode = null;
        for (int i=0;i<arr.length;i++) {
            ListNode node = new ListNode(arr[i]);
            if(head == null) {
                head = node;
                pre = node;
            }else {
                pre.next= node;
                pre = node;
                last = node;
            }
            if (node.val == 5) {
                rinNode = node;
            }
        }
        last.next = rinNode;

        return head;
    }
}
