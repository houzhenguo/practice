package com.example.suan.bit;

public class BitTest {
    public static void main(String[] args) {
//        int a = ~44;
//        System.out.println(Integer.toBinaryString(44));
//        System.out.println(Integer.toBinaryString(a));

        // 统计 a b 两个数字的二进制位中有少个不同的
        int a = 14;
        int b = 11;
        System.out.println("a is" +Integer.toBinaryString(a));
        System.out.println("b is" +Integer.toBinaryString(b));
        int c = a ^b; // ^ 可以理解位 !or ； 相同为 0 不同为 1
        System.out.println("c is" +Integer.toBinaryString(c));
        int count = 0;
        int i = 0;
        while (c != 0) { // 通过与 1（它的二进制就是1）进行 &操作，可以确认末位是否为1 ，然后通过不断的右移消掉最右的
            if((c & 1) == 1) {
                count++;
            }
            i++;
            System.out.println("第 "+ i+"次" + Integer.toBinaryString(c));
            c=c>>1;
        }
        System.out.println("最后"+count);
    }

}
