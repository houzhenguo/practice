package com.example.suan.link;

public class DelRepeatNodeTest {
    public static void main(String[] args) {

    }
    // 删除有序链表中 重复的的节点 1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode  removeRepeatNode(ListNode head) {
        ListNode preNode = head;
        ListNode current = head;
        while (current.next != null)
            if (current.val == current.next.val) {
                current = current.next;
            }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}

