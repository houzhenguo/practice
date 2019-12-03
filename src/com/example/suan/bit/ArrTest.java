package com.example.suan.bit;

public class ArrTest {
    public static void main(String[] args) {
        int[] a = {0,1,3};
        int miss = missingNumber(a);
        System.out.println(miss);
    }
    public static int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
       // System.out.println(ret);
        return ret ^ nums.length;
    }
}
