package com.example.suan.string;

public class ReplaceCharTest {
    public static void main(String[] args) {
        // replace space by %20
        String str = "hello world !";
        char[] strChars = str.toCharArray();
        int countSpace = 0;
        for (char c : strChars) {
            if (c == ' ') {
                ++countSpace;
            }
        }
        char [] newChar = new char[strChars.length + 2 * countSpace];
        int j=0;
        for (int i=0; i< strChars.length;i++) {
            if(strChars[i] == ' ') {
                newChar[j] = '%';
                newChar[j+1] = '2';
                newChar[j+2] = '0';
                j+=2;
            }else {
                newChar[j] = strChars[i];
            }
            j++;
        }
        System.out.println(new String(newChar)); // hello%20world%20!
    }
}
