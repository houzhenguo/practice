package com.example.suan.other;

import com.alibaba.fastjson.JSON;

public class KeepLive {
    public String type ="KeepLive";
    public static void main(String[] args) {

        System.out.println(JSON.toJSONString(new KeepLive()));
    }
}
