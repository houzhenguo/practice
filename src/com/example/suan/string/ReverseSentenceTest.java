package com.example.suan.string;

import java.util.Arrays;

public class ReverseSentenceTest {
    public static void main(String[] args) {
        //System.out.println(reverseSentence("student. a am I"));
        String s = reverseSentence1("student. a am I");
        System.out.println(s);
    }
    // student. a am I -> I am a student.
    public static String reverseSentence(String str) {
        if (str == null) {
            return null;
        }
        String[] strArray = str.split(" ");
        int i = 0;
        int j = strArray.length -1;
        while (i < j) {
            String temp = strArray[i];
            strArray[i] = strArray[j];
            strArray[j] = temp;
            ++i;
            --j;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strArray) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }
    // student. a am I -> I am a student.
    // .tneduts a ma I -> I am a student. 都他娘的是人才
    public static String reverseSentence1(String str) {
        char[] chars = str.toCharArray();
        // 1. 先将每个单词进行反转
        // 2. 将整个字符串反转
        int i = 0;
        int len = chars.length -1;
        int j = 0;
        while (i <= len) {
            if (chars[i] ==' ' || i == len) { // 遇到空格或者结束
                reverse(chars, j, i);
                j = i+1;
            }
            ++i;
        }
        reverse(chars, 0, len);
        return new String(chars);
    }
    public static void reverse(char[] chars , int i, int j) {
        while (i <j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            ++i;
            --j;
        }
    }
}
