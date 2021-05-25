package com.dddinjava.portal.dao;

import com.dddinjava.portal.entity.Account;
import org.apache.ibatis.annotations.*;

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
    int save(Account account);

    /**
     * 查询所有帐户
     * @return 帐户集合
     */
    List<Account> list();

    /**
     * 修改
     * @param account
     * @return
     */
    @Update("update account set username= #{username}, password=#{password}, owner_full_name=#{ownerFullName} where id= #{id}")
    int update(Account account);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from account where id = #{id}")
    int delete(@Param("id") Long id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select id, username, password, owner_full_name from account where id = #{arg0}")
    Account findById(Long id);
}
