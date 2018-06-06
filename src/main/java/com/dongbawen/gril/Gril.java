package com.dongbawen.gril;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/6 15:27
 * @modified by
 * @modify date
 * @company:云南东巴文信息技术有限公司
 */
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})/*没有这用id查询时报错*/
public class Gril implements Serializable {

    @Id
    @GeneratedValue /*自增*/
    private Integer id;

    private String cupSize;

    private Integer age;

    /**
     * 无参构造器
     * 必须
     */
    public Gril(){

     }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
