package com.huangyong.dao;

import com.huangyong.pojo.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    User findByUser(User user);
}