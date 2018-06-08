package com.dongbawen.user.controller;

import com.dongbawen.tools.Result;
import com.dongbawen.tools.ResultUtil;
import com.dongbawen.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author missli
 * @description TODO
 * @create date 2018/6/8 14:24
 * @modified by
 * @modify date
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users")
    @ResponseBody
    public Result getAllUser(){
        return ResultUtil.success(userRepository.findAll());
    }

    @GetMapping(value = "/fmindex")
    public String freIndexUser(ModelMap map){
        map.addAttribute("data",ResultUtil.success(userRepository.findAll()));
        return "freemarker/center/test";
    }

    @GetMapping(value = "/tlindex")
    public String thIndexUser(ModelMap map){
        map.addAttribute("data",ResultUtil.success(userRepository.findAll()));
        return "thymeleaf/index";
    }

    /**
     * 测试全局异常捕获
     * @return
     */
    @GetMapping(value = "/exception")
    public Integer testException(){
        return 1/0;
    }

}
