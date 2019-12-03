package com.example.test.enumf;

public enum ErrorCode {
    NULL(0, "null"),
    LAST(999,"max");
    private int key;
    private String desc;
    ErrorCode(int key, String desc) {
        this.key = key;
        this.desc = desc;
    }
    public int getKey() {return key;}
}
