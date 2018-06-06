package com.dongbawen.gril;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/6 15:41
 * @modified by
 * @modify date
 * @company:云南东巴文信息技术有限公司
 */
@RequestMapping("/gril")
@RestController
public class GrilController {

    @Autowired
    private GrilRepository grilRepository;

    /**
     * 查询一个列表
     * @return
     */
    @GetMapping(value = "/grils")
    public List<Gril> grilList(){
        return grilRepository.findAll();
    }

    /**
     * 添加一条记录
     * @param age
     * @param cupSize
     * @return
     */
    @PostMapping(value = "/grils")
    public Gril addGril(@RequestParam(value = "age") Integer age,
                          @RequestParam(value = "cupSize") String cupSize){
        Gril gril = new Gril();
        gril.setAge(age);
        gril.setCupSize(cupSize);
        return grilRepository.save(gril);
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

}
