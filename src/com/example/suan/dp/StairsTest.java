package com.example.suan.dp;

public class StairsTest {
    public static void main(String[] args) {
        System.out.println(stairs(3));
    }
    // DP 上楼梯
    public static int stairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int pre1 = 1; // 代表前 1 阶
        int pre2 = 2; // 代表前 2 阶
        int pre = 0;  // 当前
        for (int i=3;i<=n;i++) {
            pre = pre1 + pre2; // 当前的等于前两种的和
            pre2 = pre1; // 先将 pre1 -> pre2 避免数据丢失
            pre1 = pre; // 将 pre -> pre1
        }
        return pre;
    }
}
