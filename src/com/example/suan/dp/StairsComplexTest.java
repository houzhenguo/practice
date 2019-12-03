package com.example.suan.dp;

import java.util.Arrays;

public class StairsComplexTest {
    public static void main(String[] args) {
        int res1= JumpFloorII(10);
        int res2 = stairs(10);
        System.out.println(res1);
        System.out.println(res2);
    }
    // 复杂版跳台阶，不限制一次跳几个
    public static int stairs(int n) {
        int[] dp = new int[n]; // 创建 dp数组
        Arrays.fill(dp,1); // 全部填充1，可以直接跳上去，不管前面的，所以默认填充1
        for (int i= 0; i<n; i++) {
            for (int j=0;j<i;j++) { // 处理一下前面的
                dp[i] += dp[j]; // 把前面所有的次数累加起来就是当前的（注意dp[i]已经有一个值为1）
            }
        }
        return dp[n-1];// 返回
    }

    public static int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }
}
