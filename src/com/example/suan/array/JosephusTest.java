package com.example.suan.array;

import java.util.Arrays;

public class JosephusTest {
    public static void main(String[] args) {
        test(5,3);
    }
    // 约瑟夫环 n ->n个人，m ->每隔m个人出队 1 2 3 4 5 ,
    public static void test(int n, int m) {
        // 手撕约瑟夫环 使用数组
        int[] nums = new int[n]; //
        Arrays.fill(nums, 1);
        int remainCount = n; // 剩余的人数
        int count = 0; //有效值的个数
        while (remainCount >1) { // 当剩余值等于1 的时候跳出
            int i = 0;
            while (i < n) { // 每次遍历数组
                if (nums[i] == 1) {
                    ++count; // 如果数组位置为1 代表有效，可以计数
                    if (count == m) { // 当计数达到 m 时候，将 i 个位置 =0
                        nums[i] = 0;
                        --remainCount; // 减少一个有效值
                        if(remainCount ==1) {
                            break;
                        }
                        count =0; // reset 只有这时候可以重置为0 ，考虑 循环 -> index0
                    }

                }
                ++i;
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
    }
}
