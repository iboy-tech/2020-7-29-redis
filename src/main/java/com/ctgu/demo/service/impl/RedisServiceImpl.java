package com.ctgu.demo.service.impl;

import com.ctgu.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: yanghao
 * @Date: 2020/7/29 20:48
 * @PackageName:com.ctgu.demo.service.impl
 * @Description: TODO
 * @Version:V1.0
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void set(String key, Object object) {
        redisTemplate.opsForValue().set(key,object);
    }

    @Override
    public Long incr(String key) {
        redisTemplate.setDefaultSerializer(RedisSerializer.string());
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.string());
        return redisTemplate.opsForValue().increment(key);
    }

    @Override
    public String getIncr(String key) {
        return stringRedisTemplate.opsForValue().get("view");
    }

    @Override
    public void expire(String key, Integer value) {
        redisTemplate.expire(key,value, TimeUnit.SECONDS);
    }
}
