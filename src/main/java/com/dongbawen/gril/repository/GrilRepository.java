package com.dongbawen.gril.repository;

import com.dongbawen.gril.domain.Gril;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/6 15:44
 * @modified by
 * @modify date
 */
public interface GrilRepository extends JpaRepository<Gril, Integer> {

    /**
     * 扩展查询
     * 命名要规范
     * @return
     */
    public List<Gril> findByAge(Integer age);
}
