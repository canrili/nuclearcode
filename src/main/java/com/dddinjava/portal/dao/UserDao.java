package com.dddinjava.portal.dao;

import com.dddinjava.portal.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表数据访问层
 * @author zhaox
 */
@Mapper
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);
}
