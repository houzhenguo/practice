package com.example.suan.dp;

/**
 *  打家劫舍 利润最大化
 */
public class RobTest {
    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        int res = rob(nums);
        System.out.println(res);
    }
    // 2,7,9,3,1
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i< n;i++) {
            // 偷 与 不偷的问题
            dp[i] = Math.max(dp[i-2] +nums[i], dp[i-1]);
        }
        return dp[n-1];
    }

    public static int rob1(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
