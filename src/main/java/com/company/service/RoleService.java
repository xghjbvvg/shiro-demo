package com.company.service;

import com.company.domain.Role;

import java.util.List;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 14:09
 * @Description:
 */
public interface RoleService {
    List<Role> findRoleByUserId(Integer id);
}
