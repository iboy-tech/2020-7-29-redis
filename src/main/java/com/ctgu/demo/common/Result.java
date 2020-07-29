package com.ctgu.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.management.counter.perf.PerfInstrumentation;

import java.io.Serializable;

/**
 * @Auther: yanghao
 * @Date: 2020/7/28 23:38
 * @PackageName:com.ctgu.demo.common
 * @Description: TODO
 * @Version:V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private static final long serialVersionUID = -6028391958085013879L;
    private Integer code=200;
    private boolean success=true;
    private String msg="请求成功";
    private Object data=null;
}
