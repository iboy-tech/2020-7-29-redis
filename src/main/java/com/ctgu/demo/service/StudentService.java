package com.ctgu.demo.service;

import com.ctgu.demo.pojo.Student;

import java.util.List;

/**
 * @Auther: yanghao
 * @Date: 2020/7/28 23:31
 * @PackageName:com.ctgu.demo.service
 * @Description: TODO
 * @Version:V1.0
 */
public interface StudentService {
    void addStudent(Student student);
    List<Student> findAll();
    void deleteStudentById(String id);
}
