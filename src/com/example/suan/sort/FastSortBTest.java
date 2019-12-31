package com.example.suan.sort;

// 默写练习
public class FastSortBTest {
    public static void main(String[] args) {
        int[] nums = {7,6,5,4,3,2,1};
        fast(nums, 0, nums.length-1);
        for (int n : nums) {
            System.out.println(n);
        }
    }
    public static void fast(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int temp = nums[low];
        while (i < j) {
            while (i < j && temp < nums[j]) {
                --j;
            }
            if(i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && temp > nums[i]) {
                ++i;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
            nums[i] = temp;
            fast(nums, low, i-1);
            fast(nums, i+1, high);
        }
    }
}
