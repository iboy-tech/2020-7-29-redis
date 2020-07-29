package com.ctgu.demo.controller;

import com.ctgu.demo.common.Result;
import com.ctgu.demo.common.enums.ErrorEnum;
import com.ctgu.demo.dao.StudentDao;
import com.ctgu.demo.pojo.Student;
import com.ctgu.demo.service.RedisService;
import com.ctgu.demo.service.StudentService;
import com.ctgu.demo.util.RestfulUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: yanghao
 * @Date: 2020/7/28 23:34
 * @PackageName:com.ctgu.demo.controller
 * @Description: TODO
 * @Version:V1.0
 */
@RestController
@Slf4j
@RequestMapping("/students")
@CacheConfig(cacheNames = "student:")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentDao studentDao;

      @Autowired
      RedisService redisService;


    @GetMapping("")
    @Cacheable()
    public Result findAll(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
//        分页查询
        Sort sort=Sort.by("createTime").descending().and(Sort.by("id").ascending());
        Pageable pageable = PageRequest.of(page-1,limit,sort);
        Page<Student> studentPage=studentDao.findAll(pageable);
//        List<Student> students=studentPage.getContent();

/*        students.forEach(item->{
            redisService.set("user:"+item.getUsername(),item);
        });*/

        HashMap map=new HashMap();
        map.put("code",0);
        map.put("count",studentPage.getTotalElements());
        map.put("data",studentPage.getContent());
        return RestfulUtil.success(map);
    }

    @PostMapping("")
    public Result addStudent(@RequestBody Student student){
        try {
            studentService.addStudent(student);
        }
        catch (Exception e){
            e.printStackTrace();
            return RestfulUtil.error(ErrorEnum.USER_EXISTS);
        }

        return RestfulUtil.success("添加成功");
    }

}
