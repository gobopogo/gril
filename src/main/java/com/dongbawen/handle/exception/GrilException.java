package com.dongbawen.handle.exception;

import com.dongbawen.tools.ResultEum;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/7 15:00
 * @modified by
 * @modify date
 */
public class GrilException extends RuntimeException {
/*如果继承的是Exception的话不会进行数据回滚*/

    private Integer code;

    public GrilException(ResultEum resultEum) {
        super(resultEum.getMsg());
        this.code = resultEum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
