package com.dongbawen.gril.handle;

import com.dongbawen.gril.ResultUtil;
import com.dongbawen.gril.domain.Result;
import com.dongbawen.gril.enums.ResultEum;
import com.dongbawen.gril.exception.GrilException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/7 14:48
 * @modified by
 * @modify date
 */
@ControllerAdvice
public class ExceptionHandle {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 捕获异常
     * @ExceptionHandler 要捕获的异常类
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GrilException){
            GrilException grilException = (GrilException) e;
            return ResultUtil.error(grilException.getCode(),grilException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(ResultEum.UNKNOW_ERROR);
        }
    }
}
