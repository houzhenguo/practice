package com.example.suan.sort;

// 快速排序 练习版本 A 20191231
public class FastSortATest {
    public static void main(String[] args) {
        int[] nums = {7,6,5,4,3,2,1};
        fastSort(nums, 0, nums.length-1);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    public static void fastSort(int[] nums, int low, int high) {
        // 1. 快速排序的核心思想： 选取一个值，并且最终把它放到合理的位置 左边的都比它小，右边的都比它大，两个指针 i, j
        // 2. 先尝试找位置
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = nums[low];
        while (i < j) {
            while (nums[j] > temp && i<j) {
                --j;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i<j && nums[i] < temp) {
                ++i;
            }
            if(i < j) {
                nums[j--] = nums[i];
            }
            nums[i] = temp;
            fastSort(nums, low, i-1);
            fastSort(nums, i+1, high);
        }
    }
}
