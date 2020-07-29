package com.ctgu.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        SetOperations operations=redisTemplate.opsForSet();
        operations.add("s1", "v1");
        operations.add("s1","v2");
        Cursor<String>cursor=operations.scan("s1", ScanOptions.NONE);
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    @Test
    @DisplayName("测试Hash")
    void testHash(){
        HashOperations<String,String,String> operations=redisTemplate.opsForHash();
        HashMap map=new HashMap();
        map.put("t1","tv1");
        operations.putAll("h1",map);
        operations.put("h1","k1","v1");
        operations.put("h1","k2","v2");
        operations.put("h1","k3","m2");
        Cursor<Map.Entry<String, String>> cursor=operations.scan("h1", new ScanOptions.ScanOptionsBuilder().match("*k*").build());
        while (cursor.hasNext()){
            Map.Entry<String,String> entry = cursor.next();
            System.out.println(entry.getKey());;
        }
//        System.out.println(redisTemplate.opsForHash().entries("h1"));
    }

}
