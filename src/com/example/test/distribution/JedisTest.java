package com.example.test.distribution;

import redis.clients.jedis.Jedis;

public class JedisTest {
    private static final Jedis jedis = new Jedis("39.96.160.227",6379);
    private JedisTest(){}
    public static Jedis getJedis() {
        return jedis;
    }
    public static void main(String[] args) {
        String val = getJedis().get("foo");  // bar
        System.out.println(val);
    }
}
