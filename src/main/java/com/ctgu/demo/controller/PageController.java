package com.ctgu.demo.controller;

import com.ctgu.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: yanghao
 * @Date: 2020/7/28 23:34
 * @PackageName:com.ctgu.demo.controller
 * @Description: TODO
 * @Version:V1.0
 */
@Controller
public class PageController {
    @Autowired
    RedisService redisService;
    @GetMapping("/")
    public String index(){
        redisService.incr("view");
        return "index";
    }
}
