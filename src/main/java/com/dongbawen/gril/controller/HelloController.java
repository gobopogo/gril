package com.dongbawen.gril.controller;

import com.dongbawen.gril.properties.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/5 16:39
 * @modified by
 * @modify date
 * @company:云南东巴文信息技术有限公司
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private GrilProperties grilProperties;

    /*
    * 也可以写成 /{id}/hello
    * url：http://localhost:8080/gril/hello/hello/100
    * */
    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String helloWord(@PathVariable("id") Integer id){
        return "ID: " + id.toString();
    }

    /**
     * url: http://localhost:8080/gril/hello/hello1?id=100
     * required = false
     * @param id
     * @return
     */
    //@RequestMapping(value = "/hello1", method = RequestMethod.GET)
    @GetMapping(value = "/hello1")
    public String hello1(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
        return "ID: " + id.toString();
    }

    /*
    * 两个url对应一个方法
    * 不写method的话 GET或POST请求都没问题
    * */
    @RequestMapping(value = {"/test1","/tes"}, method = RequestMethod.GET)
    public String test1(){
        return grilProperties.getCupSize();
    }
}
