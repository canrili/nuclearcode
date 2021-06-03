package com.dddinjava.portal.dao;

import com.dddinjava.portal.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author zhaox
 */
@Mapper
public interface AccountMapper {

    /**
     * 查询所有帐户信息
     * @param id
     * @return
     */
    @Cacheable(value = "users", key = "#id")
    List<Account> list(Long id);

}
