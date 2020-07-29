package com.ctgu.demo.service.impl;

import com.ctgu.demo.dao.StudentDao;
import com.ctgu.demo.pojo.Student;
import com.ctgu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yanghao
 * @Date: 2020/7/28 23:31
 * @PackageName:com.ctgu.demo.service.impl
 * @Description: TODO
 * @Version:V1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Override
    public void addStudent(Student student) {
        studentDao.saveAndFlush(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void deleteStudentById(String id) {
        studentDao.deleteById(id);
    }
}
