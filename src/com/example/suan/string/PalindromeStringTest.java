package com.example.suan.string;

public class PalindromeStringTest {
    public static void main(String[] args) {
        boolean flag = solution("abcsdfscba");
        System.out.println(flag);
    }
    // 可以删除一个字符，判断是否能构成回文字符串。
    public static boolean solution(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length -1; // 双指针模式
        int count = 0;     
        while (i < j) {
            if (chars[i] == chars[j]) {
                ++i;
                --j;
            }else {
                if (chars[i+1] == chars[j] && i+1 < j) { // 避免 中间 adfa的情况 越界
                    ++i;
                }else if (chars[i] == chars[j-1] && i < j-1){
                    --j;
                }
                count ++;
                if (count > 1) {
                    return false;
                }
            }

        }
        if (count <=1) {
            return true;
        }
        return false;
    }
}
