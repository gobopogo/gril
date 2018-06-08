package com.dongbawen.user.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/8 14:17
 * @modified by
 * @modify date
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonIgnore  //不返回到前端
    private Integer age;

    @JsonInclude(JsonInclude.Include.NON_NULL)  //空的话，不返回到前端
    private String sex;

    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GTM+8")
    private Date berthday;

    public User(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBerthday() {
        return berthday;
    }

    public void setBerthday(Date berthday) {
        this.berthday = berthday;
    }
}
