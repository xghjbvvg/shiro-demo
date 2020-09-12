package com.company.service.impl;

import com.company.dao.RoleMapper;
import com.company.domain.Role;
import com.company.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 14:21
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleMapper roleMapper;
    @Override
    public List<Role> findRoleByUserId(Integer id) {

        return roleMapper.findRoleByUserId(id);
    }
}
