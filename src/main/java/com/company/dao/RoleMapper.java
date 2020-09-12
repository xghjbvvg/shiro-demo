package com.company.dao;

import com.company.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 14:29
 * @Description:
 */

public interface RoleMapper {

    @Select("select r.rid, r.rname from role r  left join user_role ur on ur.rid = r.rid  left join user u on u.uid = ur.uid   where u.uid = #{id}")
    List<Role> findRoleByUserId(Integer id);
}
