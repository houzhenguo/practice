package com.example.suan.array;

import java.util.Arrays;

public class ArrayOddEventNumTest {
    public static void main(String[] args) {
        int[] array = {2,3,4,5,6,8,1};
        sortOddEvenNum(array);
        Arrays.stream(array).forEach(System.out::println);
    }
    // 奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变
    public static void sortOddEvenNum(int[] array) {
        // 思路：两个指针，一个负责奇数 一个负责偶数
        // 如何保证相对的顺序？难道统计一下奇数 偶数的个数？
        // 先尝试统计一下吧(如果建立新的数组就非常容易解决了，但是不想用这种办法)

        // 使用冒泡排序的思想?(重点)
        for (int i = array.length -1; i>0;i--) {
            for (int j = 0;j <i;j++) { // 外层循环倒着只是控制尾值的
                if (array[j] %2 ==0 && array[j+1] %2 != 0) {
                    swap(array, j, j+1);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
