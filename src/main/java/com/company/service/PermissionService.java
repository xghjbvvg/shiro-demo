package com.company.service;

import java.util.List;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 14:10
 * @Description:
 */
public interface PermissionService {
    List<String> findByRoleId(List<Integer> roleIds);
}
