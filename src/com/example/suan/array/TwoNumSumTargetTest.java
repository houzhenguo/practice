package com.example.suan.array;

import java.util.Arrays;

public class TwoNumSumTargetTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8};
        int res[] = getTwoNum(arr, 7);
        Arrays.stream(res).forEach(System.out::println);
    }
    // 找出有序数组中的两个数，使得相加等于 目标值
    public static int[] getTwoNum(int[] array, int target) {
        int[] result = new int[2];
        int j = array.length - 1; // 双指针
        int i = 0;

        while (i<j) {
            int res = array[i] + array[j];
            if (res > target) { // 当 与最小的值相加还很大时，就要移动尾使得尾部变小
                --j;
            }else if (res < target) {
                ++i;
            }else {
                result[0] = array[i];
                result[1] = array[j];
                return result;
            }
        }
        return result;
    }
}
