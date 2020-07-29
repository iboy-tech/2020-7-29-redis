package com.ctgu.demo.controller;

import com.ctgu.demo.common.Result;
import com.ctgu.demo.common.enums.ErrorEnum;
import com.ctgu.demo.pojo.Student;
import com.ctgu.demo.service.RedisService;
import com.ctgu.demo.util.RestfulUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yanghao
 * @Date: 2020/7/29 21:05
 * @PackageName:com.ctgu.demo.controller
 * @Description: TODO
 * @Version:V1.0
 */
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {
    @Autowired
    RedisService redisService;

    @GetMapping("/{key}")
    public Result getStudentByKey(@PathVariable String  key){
        log.warn("调用了");
        Student student= (Student) redisService.get("user:"+key);
        log.warn(String.valueOf(student));
        return RestfulUtil.error(ErrorEnum.LOGIN_FAILED);
    }

    @GetMapping("/view")
    public String getViewCount(){
        log.warn("调用了");
        return redisService.getIncr("view");
    }




}
