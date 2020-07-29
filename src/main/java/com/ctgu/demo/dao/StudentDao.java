package com.ctgu.demo.dao;

import com.ctgu.demo.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: yanghao
 * @Date: 2020/7/28 23:30
 * @PackageName:com.ctgu.demo.dao
 * @Description: TODO
 * @Version:V1.0
 */
@Repository
public interface StudentDao extends JpaRepository<Student,String> {

    @Modifying
    @Query(value="select * from t_student where age >(?1) and id in (?2)",nativeQuery=true)
    List<Student> getStudentByAgeAndUids(Integer age,List<String>uids);

    @Modifying
    @Query(value="update t_student set username=(?1) where id=(?2)",nativeQuery=true)
    void updateStudentById(String username,String id);

    @Modifying
    @Transactional
    @Query(value="delete from  t_student  where id=(?1)",nativeQuery=true)
    void deleteStudentByusername(String uid);
}
