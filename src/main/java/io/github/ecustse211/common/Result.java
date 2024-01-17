package io.github.ecustse211.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口统一返回包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private String code;
    private String msg;
    private Object data;


    public static Result success() {    //默认成功
        return new Result(Constants.CODE_200, "", null);
    }

    public static Result success(Object data) { //具体成功
        return new Result(Constants.CODE_200, "", data);
    }

    public static Result error(String code, String msg) {   //具体错误
        return new Result(code, msg, null);
    }

    public static Result error() {  //默认错误
        return new Result(Constants.CODE_500, "系统错误", null);
    }

}
