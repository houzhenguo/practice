package com.example.suan.sort;

import java.util.PriorityQueue;

public class ProperitySortTest {
    // 在未排序的数组中找到第 k 个最大的元素。
    // 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,2));
    }
    // 无序数组中 第 K 大
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2)->n1-n2);
        for (int n : nums) {
            queue.add(n);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

}
