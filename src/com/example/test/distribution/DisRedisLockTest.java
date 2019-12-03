package com.example.test.distribution;

import redis.clients.jedis.Jedis;

public class DisRedisLockTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        // key: 加锁 value 为 设定的值  NX 代表加锁 EX 代表过期时间
        jedis.set("key","value","NX","EX",30);
    }
}
