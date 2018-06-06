package com.dongbawen.gril;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/6 9:06
 * @modified by
 * @modify date
 * @company:云南东巴文信息技术有限公司
 */
@Component //HelloController中使用@Autowired注入这个类的时候不会报错
@ConfigurationProperties(prefix = "girl")
public class GrilProperties {
    private String cupSize;

    private Integer age;

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