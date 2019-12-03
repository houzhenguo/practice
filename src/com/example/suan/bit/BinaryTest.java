package com.example.suan.bit;

public class BinaryTest {
    public static void main(String[] args) {
//        boolean flag = intToBinaryIndex(4,2);
//        System.out.println("flag" + flag);
        System.out.println(getBinary1Num(3));
    }

    /**
     *  判断 num 的第 index 位置是否为 1
     * @param num
     * @param index
     * @return
     */
    public static boolean intToBinaryIndex(int num, int index) {
        System.out.println("num 的二进制位"+Integer.toBinaryString(num));
        int temp = 1 << (index-1);
        System.out.println("index 移位之后" + Integer.toBinaryString(temp));
        return (num & temp) == temp;
    }

    /**
     *  统计数字的二进制位中包含几个1
     *   判断
     * @param num
     * @return
     */
    public static int getBinary1Num(int num) {
        int count = 0;
        while (num != 0) {
            num &= (num -1);
            count++;
        }
        return count;
    }
}
