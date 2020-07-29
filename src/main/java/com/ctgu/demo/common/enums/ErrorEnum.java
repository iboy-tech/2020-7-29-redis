package com.ctgu.demo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Auther: yanghao
 * @Date: 2020/7/28 23:40
 * @PackageName:com.ctgu.demo.common.enums
 * @Description: TODO
 * @Version:V1.0
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorEnum {
    LOGIN_FAILED("登录失败",1000),
    PERMISSION_DENIED("权限不足",2000),
    USER_EXISTS("用户已存在",3000);
    private String msg;
    private Integer code;
}
