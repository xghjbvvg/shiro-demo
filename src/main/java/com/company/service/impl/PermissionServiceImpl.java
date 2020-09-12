package com.company.service.impl;

import com.company.dao.PermissionMapper;
import com.company.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 14:21
 * @Description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    PermissionMapper permissionMapper;
    @Override
    public List<String> findByRoleId(List<Integer> roleIds) {

        return permissionMapper.findByRoleId(roleIds);
    }
}
