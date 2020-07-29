package com.ctgu.demo.util;

import com.ctgu.demo.common.Result;
import com.ctgu.demo.common.enums.ErrorEnum;

/**
 * @Auther: yanghao
 * @Date: 2020/7/28 23:42
 * @PackageName:com.ctgu.demo.util
 * @Description: TODO
 * @Version:V1.0
 */
public class RestfulUtil {

    public static Result success(){
        Result result = new Result();
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setData(data);
        return result;
    }

    public static Result success(String msg){
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }


    public static Result success(String msg,Object data){
        Result result = new Result();
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result error(ErrorEnum errorEnum){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(errorEnum.getCode());
        result.setMsg(errorEnum.getMsg());
        return result;
    }

}
