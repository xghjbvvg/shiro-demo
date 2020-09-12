package com.company.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 14:36
 * @Description:
 */
public interface PermissionMapper {



    List<String> findByRoleId(@Param("roleIds") List<Integer> roleIds);
}
