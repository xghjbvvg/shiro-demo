package com.company.dao;

import com.company.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: 12640
 * @Date: 2020/9/12 14:19
 * @Description:
 */
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User findByAccount(String username);
}
