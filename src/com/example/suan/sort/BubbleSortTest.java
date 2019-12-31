package com.example.suan.sort;

public class BubbleSortTest {

    public static void main(String[] args) {
        int[] nums = {7,6,5,4,3,2,1};
        bubbleSort(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }
    // 冒泡排序
    public static void bubbleSort(int[] nums) {
        boolean sorted = false;
       for (int i = nums.length -1; i>= 0 && !sorted; i--) {
           sorted = true; // 如果一轮下来 没有数据的交换，说明所有数据已经在 合理的位置上了
           for (int j = 0; j < i;j++ ) {
                if(nums[j] > nums[j+1]) {
                    swap(nums, j,j+1);
                    sorted = false;
                }
           }
       }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp    = nums[i];
        nums[i]     = nums[j];
        nums[j]     = temp;
    }
}
