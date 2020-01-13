package com.example.suan.string;

public class StringTest {
    public static void main(String[] args) {
        String s = new String("a"); // byte[] not char[]

        String a = new String("av").intern();
        String b = "a"+"v";
        System.out.println(a==b);
    }
}
