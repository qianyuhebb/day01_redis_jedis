package com.qianfeng;

import redis.clients.jedis.Jedis;

/**
 * 时间：  2020/2/6
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
public class TestJedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.25.128", 8000);
        jedis.set("string","123");
        jedis.lpush("list","456");
        jedis.zadd("zset",1,"789");
        Long zset = jedis.zcard("zset");


        jedis.hset("hash","小key","001");



    }
}
