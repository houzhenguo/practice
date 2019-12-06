package com.example.suan.string;

import java.util.Arrays;

public class SplitStringTest {
    public static void main(String[] args) {
       // String s = split("hellhool",'h',2);
        String s1 = split("hello",'a',2);

    }
    // byte dance 题目， target目标字符串，
    public static String split(String target, char splitChar, int index) {
        if (target == null) {
            return null;
        }
        char[] chars = target.toCharArray();
        int begin = 0;
        int end = 0;
        int count = 0; // 判断是否包含的问题。这里就不写了
        for (int i = 0;i< chars.length;i++) {
            if (chars[i] == splitChar || (i == chars.length -1 && count >0)) { // 注意临界条件
                end = i-1; // end为前一个取值
                if(i == chars.length -1) {
                    end = chars.length -1;
                }
                if(count == index) { // 试想 第 0 组
                    break;
                }
                count++;
                begin = i+1;
            }
        }
        System.out.println(begin);
        System.out.println(end);

        return null;
    }
}
