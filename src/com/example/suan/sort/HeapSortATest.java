package com.example.suan.sort;

// heap sort 练习
public class HeapSortATest {
    // 堆排序的主要核心思想是： 构建堆 ->
    // 对于一个数组来说，按层 遍历 的编号 0 开始
    public static void main(String[] args) {
        int[] nums = {2,5,3,1,10,4};
        heapSort(nums, nums.length);
        printfNums(nums);
    }

    /**
     *  调整 i 节点，使得父节点最大
     * @param nums
     * @param n
     * @param i
     */
    public static void heapify (int[] nums, int n, int i) {
        if (i>= n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if(c1 <n && nums[c1] > nums[max]) {
            max = c1;
        }
        if (c2 < n && nums[c2] > nums[max]) {
            max = c2;
        }
        if (max != i) {
            swap(nums, i, max);
            heapify(nums, n, max);
        }
    }
    public static void buildHeap(int[] nums, int n) {
        int lastNode = n-1;
        int lastParent = (lastNode -1) /2;
        for (int i = lastParent;i>=0;i--) {
            heapify(nums, n, i);
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void heapSort(int[] nums, int n) {
        buildHeap(nums, n); // 对于无序的数组先进行构建堆
        printfNums(nums);
        System.out.println("-----");
        for (int i= n-1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i-1, 0); // 直接对 0 节点做heapify就行了
        }
    }

    public static void printfNums(int[] num) {
        for (int i=0; i< num.length;i++) {
            System.out.println(num[i]);
        }
    }
}
