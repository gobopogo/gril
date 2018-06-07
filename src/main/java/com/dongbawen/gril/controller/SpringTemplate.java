package com.dongbawen.gril.controller;

import com.dongbawen.gril.properties.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/6 9:53
 * @modified by
 * @modify date
 * @company:云南东巴文信息技术有限公司
 */
//@RestController /*等于@Controller和@ResponseBody*/
@Controller
@ResponseBody
public class SpringTemplate {

    @Autowired
    private GrilProperties grilProperties;

    /**
     * 通过Spring的一个模板引擎spring-boot-starter-thymeleaf解析
     * @return index.html
     */
    @RequestMapping(value = "/tem1", method = RequestMethod.GET)
    public String tem1(){
        return grilProperties.getCupSize();
        //return "index"; /*返回模板，Controller不需要@ResponseBody注解*/
    }
}
