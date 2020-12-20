package com.huangyong.service.impl;

import com.huangyong.dao.UserMapper;
import com.huangyong.pojo.User;
import com.huangyong.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = new User();
        user.setLogin_user_name(username);
        user.setLogin_password(password);
        return userMapper.findByUser(user);
    }
}
