package com.company.service;

import com.company.domain.User;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 14:09
 * @Description:
 */
public interface UserService {
    User findByAccount(String username);
}
