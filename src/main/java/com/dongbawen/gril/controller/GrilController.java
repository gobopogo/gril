package com.dongbawen.gril.controller;

import com.dongbawen.gril.ResultUtil;
import com.dongbawen.gril.domain.Gril;
import com.dongbawen.gril.domain.Result;
import com.dongbawen.gril.repository.GrilRepository;
import com.dongbawen.gril.service.GrilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/6 15:41
 * @modified by
 * @modify date
 */
@RequestMapping("/gril")
@RestController
public class GrilController {

    private final static Logger logger = LoggerFactory.getLogger(GrilController.class);

    @Autowired
    private GrilRepository grilRepository;

    @Autowired
    private GrilService grilService;

    /**
     * 查询一个列表
     * @return
     */
    @GetMapping(value = "/grils")
    public List<Gril> grilList(){
        logger.info("Controller层！！");
        return grilRepository.findAll();
    }

    /**
     * 添加一条记录
     * @return
     */
    @PostMapping(value = "/grils")
    /*public Gril addGril(@RequestParam(value = "age") Integer age,
                          @RequestParam(value = "cupSize") String cupSize){
        Gril gril = new Gril();
        gril.setAge(age);
        gril.setCupSize(cupSize);
        return grilRepository.save(gril);
    }*/
    public Result<Gril> addGril(@Valid Gril gril, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultUtil.error(0,bindingResult.getFieldError().getDefaultMessage());
        }
        gril.setAge(gril.getAge());
        gril.setCupSize(gril.getCupSize());

        return ResultUtil.success(grilRepository.save(gril));
    }

        /**
         * 通过id查询唯一记录
         * @return
         */
    @GetMapping(value = "/grils/{id}")
    public Gril getGrilbyId(@PathVariable("id") Integer id){
        return grilRepository.getOne(id);
    }

    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    @GetMapping(value = "/grils/age/{age}")
    public List<Gril> getByAge(@PathVariable("age") Integer age){
        return grilRepository.findByAge(age);
    }

    /**
     * 提交put请求的http格式用x-www-form-urlencoded，不能用form-data
     * @param id
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/grils/{id}")
    public Gril update(@PathVariable("id") Integer id,
                       @RequestParam(value = "age") Integer age,
                       @RequestParam(value = "cupSize") String cupSize){
        Gril gril = new Gril();
        gril.setId(id);
        gril.setAge(age);
        gril.setCupSize(cupSize);
        return grilRepository.save(gril);
    }

    /**
     * 根据id 删除一条记录
     * @param id
     * @return
     */
    @DeleteMapping(value = "/grils/{id}")
    public String delete(@PathVariable("id") Integer id){
        grilRepository.deleteById(id);
        return "删除成功！";
    }

    /**
     * 判断不同年龄，返回不同结果
     * 练习异常统一管理 异常抛出、捕获、返回结果统一、结果状态枚举管理
     * @param id
     */
    @GetMapping(value = "/grils/getAge/{id}")
    public void getAge(@PathVariable(value = "id") Integer id){
        grilService.getAge(id);
    }
}
