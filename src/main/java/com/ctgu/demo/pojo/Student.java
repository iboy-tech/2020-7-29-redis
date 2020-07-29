package com.ctgu.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @Auther: yanghao
 * @Date: 2020/7/28 23:11
 * @PackageName:com.ctgu.demo.pojo
 * @Description: TODO
 * @Version:V1.0
 */
@Entity
@Table(name = "t_student" )
@Data
@EntityListeners(AuditingEntityListener.class)
public class Student implements Serializable {

    private static final long serialVersionUID = 3425938558042613384L;

    @Id
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Column(nullable = false,unique = true,length = 25)
    private String username;

    @Column(nullable = false,length = 255)
    private String password;

    @Column(nullable = false,unique = true,length = 11)
    private String phone;


    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String sex;


    @CreatedDate
    @Column(name = "create_time",updatable = false,nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @LastModifiedDate
    @Column(name = "modify_time",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;

}
