package com.example.test.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        // 存储
        jedis.set("haha" ,"houzhenguo");
        System.out.println(jedis.get("haha"));
        // lpush
        jedis.lpush("list","王");
        jedis.lpush("list","张");
        jedis.lpush("list","李");
        jedis.lpush("list","赵");
        List<String> list = jedis.lrange("list",0,-1);
        list.forEach(System.out::println);
    }
}
