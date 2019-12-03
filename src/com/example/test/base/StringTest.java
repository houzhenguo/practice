package com.example.test.base;

public class StringTest {
    public static void main(String[] args) {
//        System.out.println(((1<3)?"a":"b")+3+4);
//        System.out.println(((1<3)?"a":"b")+(3+4));
        String str1 = "a" + "b" + "c";
        String str2 = "a";
        String str3 = "bc";
        System.out.println(str1 == "abc");
    }
}
