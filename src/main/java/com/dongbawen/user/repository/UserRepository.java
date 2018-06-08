package com.dongbawen.user.repository;

import com.dongbawen.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author missli
 * @description TODO
 * @create date 2018/6/8 14:16
 * @modified by
 * @modify date
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
