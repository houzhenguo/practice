package com.example.suan.array;

import java.util.Arrays;

public class NumSquareTest {
    public static void main(String[] args) {
        //2*2 + 3*3 = 13
        //System.out.println(Math.sqrt(13));
        Arrays.stream(getTwoNum(13)).forEach(System.out::println); // 2 3
    }
    // 给定一个非负整数判断是否可以分解成两个数的平方和
    public static int[] getTwoNum(int target) {
        int[] result = new int[2];
        int sqrtNum = (int)Math.sqrt(target);
        int i = 1;
        int j = sqrtNum;
        while (i <= j) {
            int res = i*i + j*j;
            if (res > target) {
                --j;
            }else if (res < target){
                ++i;
            }else {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
        return result;
    }
}
