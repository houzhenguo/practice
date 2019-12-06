package com.example.suan.string;

public class SubStringTest {
    // lee 524
    public static void main(String[] args) {
        boolean flag = isSubString("abpcplea","apple");
        System.out.println(flag);
        String lo = getLongString();
        System.out.println(lo);
    }
    public static String getLongString() {
        String[] strs = {"ale","apple","monkey","plea"};
        String sup = "abpcplea";
        String longStr = "";
        for (String s : strs) {
            if (isSubString(sup, s) && s.length() > longStr.length()) {
                 longStr = s;
            }
        }
        return longStr;
    }
    // 判断 sub 是不是 super 字串
    public static boolean isSubString(String sup, String sub) {
        int i = 0;
        int j = 0;
        while(i < sup.length() && j < sub.length()) {
            if(sup.charAt(i) == sub.charAt(j)) {
                ++j; // j 控制的是 字串的变化
            }
            ++i; // 如果匹不匹配都移动 父串 i
        }
        if (j == sub.length()) {
            return true;
        }
        return false;
    }
}
