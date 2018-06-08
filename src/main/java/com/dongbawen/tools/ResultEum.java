package com.dongbawen.tools;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/7 15:23
 * @modified by
 * @modify date
 */
public enum ResultEum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(1, "成功"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能还在上初中"),
    ;
    private Integer code;

    private String msg;

    ResultEum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
