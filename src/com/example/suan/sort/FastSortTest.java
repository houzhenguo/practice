package com.example.suan.sort;

import java.util.Arrays;

public class FastSortTest {
    public static void main(String[] args) {
        int[] arr = {2, 34, 6, 2, 7};
        sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    // 根据印象手写快速排序 (array,0,length-1)
    public static void fastSort(int array[], int begin, int end) {
        // 快速排序的核心思想是选择一个 值，使得这个值到达它最终的位置，值 的右边比它小，值的左边比它大
        // 准备两个指针，一个i，j 分别在数组的前后开始移动。
        // 其中还用到了递归的思想，当一个找到合理位置的时候，剩下的两部分分别开始使用递归
        if (begin > end) {
            return;
        }
        int i = begin;
        int j = end;
        int temp = array[begin]; // 缓存这个值
        while (i < j) {
            while (array[j] >= temp && i < j) {
                --j;
            }
            if (i < j) {
                array[i++] = array[j]; //
            }

            while (array[i] < temp && i < j) {
                ++i;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = temp;
        fastSort(array, begin, i - 1);
        fastSort(array, i + 1, end);
    }


    // 鄙人写的 快速排序
    public static void sort(int[] arr, int low, int high) {
        if(low > high) {
            return; // 递归出口
        }
        int i = low;
        int j = high;
        int temp = arr[low];
        while (i < j) {
            while (i < j && arr[j] >= temp) { // 考虑 13 44 5 13 当前情况
                --j;
            }
            if (i < j) {
                arr[i++] = arr[j]; // 赋值结束后，现在j位置是废弃的 刚开始就将 i=0被覆盖了，发动起来。
            }
            while (i < j && arr[i] < temp) {
                ++i;
            }
            if (i < j) {
                arr[j--] = arr[i];// 废弃会传播，现在i位置是废弃的
            }
        }
        arr[i] = temp;
        sort(arr, low, i -1);
        sort(arr, i+1, high);
    }
}
