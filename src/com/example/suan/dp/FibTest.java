package com.example.suan.dp;

public class FibTest {
    public static void main(String[] args) {
        // 斐波那契数列 1、1、2、3、5、8、13、21、34
        int res = fibDp(6);
        System.out.println(res);

    }
    // method1: 递归实现
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
    // DP
    public static int fibDp(int n) {
        int[] dp = new int[n]; // DP的核心思想就是这个数组缓存结果
        if (n == 1 || n == 2) {
            return 1;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
