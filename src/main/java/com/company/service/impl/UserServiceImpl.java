package com.company.service.impl;

import com.company.dao.UserMapper;
import com.company.domain.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 14:20
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Override
    public User findByAccount(String username) {

        return userMapper.findByAccount(username);
    }
}
