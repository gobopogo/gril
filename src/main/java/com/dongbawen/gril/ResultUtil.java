package com.dongbawen.gril;

import com.dongbawen.gril.domain.Result;
import com.dongbawen.gril.enums.ResultEum;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/7 14:18
 * @modified by
 * @modify date
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
    public static Result error(ResultEum resultEum){
        Result result = new Result();
        result.setCode(resultEum.getCode());
        result.setMessage(resultEum.getMsg());
        return result;
    }

}
