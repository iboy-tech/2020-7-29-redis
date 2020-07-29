package com.ctgu.demo.service;

/**
 * @Auther: yanghao
 * @Date: 2020/7/29 20:46
 * @PackageName:com.ctgu.demo.service
 * @Description: TODO
 * @Version:V1.0
 */
public interface RedisService {
    Object get(String key);
    void del(String key);
    void set(String key,Object object);
    Long incr(String key);
    String getIncr(String key);
    void expire(String key,Integer value);
}
