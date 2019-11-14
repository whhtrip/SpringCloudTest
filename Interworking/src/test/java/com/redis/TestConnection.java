package com.redis;

import redis.clients.jedis.Jedis;

/**
 * @author:WangHongHao
 * @date:19-10-14创建
 * @date：修改
 * @description：
 */
public class TestConnection {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.179.130",6379);
        System.out.println(jedis);
        String whh = jedis.get("whh");
        System.out.println(whh);
        jedis.close();
    }
}
