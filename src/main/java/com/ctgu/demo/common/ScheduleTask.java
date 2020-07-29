package com.ctgu.demo.common;

import com.ctgu.demo.dao.StudentDao;
import com.ctgu.demo.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther: yanghao
 * @Date: 2020/7/29 21:37
 * @PackageName:com.ctgu.demo.common
 * @Description: TODO
 * @Version:V1.0
 */
@Component
@Slf4j
@Async
public class ScheduleTask {
    @Autowired
    RedisService redisService;

    @Autowired
    StudentDao studentDao;

    @Scheduled(cron = "0 41 21 * * ?")
    public void asynPostView(){
        log.warn("-----------------同步浏览量----------");
    }
}
