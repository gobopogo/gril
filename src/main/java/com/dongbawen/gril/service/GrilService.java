package com.dongbawen.gril.service;

import com.dongbawen.gril.domain.Gril;
import com.dongbawen.gril.enums.ResultEum;
import com.dongbawen.gril.exception.GrilException;
import com.dongbawen.gril.repository.GrilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/7 9:54
 * @modified by
 * @modify date
 */
@Service
public class GrilService {

    @Autowired
    private GrilRepository grilRepository;

    @Transactional
    public void insertTwo(){
        Gril grilA = new Gril();
        grilA.setCupSize("A");
        grilA.setAge(18);
        grilRepository.save(grilA);

        Gril grilB = new Gril();
        grilB.setCupSize("BB");
        grilB.setAge(20);
        grilRepository.save(grilB);

    }

    public void getAge(Integer id) {
        Gril gril = grilRepository.getOne(id);
        Integer age = gril.getAge();
        if(age < 10){
            throw new GrilException(ResultEum.PRIMARY_SCHOOL);
        }else if(age >=10 && age < 16){
            throw new GrilException(ResultEum.MIDDLE_SCHOOL);
        }
        //...
    }
}
