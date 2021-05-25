package com.dddinjava.portal.dao;

import com.dddinjava.portal.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 帐户数据交互接口
 * @author zhaox
 */
@Mapper
public interface AccountMapper {
    /**
     * 保存
     * @param account 帐户
     * @return 条数
     */
    Long save(Account account);

    /**
     * 查询所有帐户
     * @return 帐户集合
     */
    List<Account> list();
}
