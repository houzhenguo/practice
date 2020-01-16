package com.example.suan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappearNumTest {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(nums);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < nums.length;i++) {
            int cur = nums[i]; // 当前下标上的值
            if(cur-1 !=i && nums[cur-1] != cur) {
               swap(nums, cur-1,i);
            }
        }
        for(int n : nums) {
            System.out.printf("n" +n);
        }
        for(int i = 0;i < nums.length;i++) {
            if (i + 1 != nums[i]) {
                res.add(i+1);
            }
        }
        return res;
    }

    public static void swap(int[] arr,int i,int j)
    {
        arr[i]=arr[i]+arr[j];
        arr[j]=arr[i]-arr[j];
        arr[i]=arr[i]-arr[j];
    }

}
