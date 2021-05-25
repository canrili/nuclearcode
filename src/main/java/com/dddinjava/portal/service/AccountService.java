package com.dddinjava.portal.service;

import com.dddinjava.portal.entity.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 账号逻辑层接口
 * @author zhaox
 */
public interface AccountService {

    /**
     * 查询所有帐户
     * @return ResponseEntity
     */
    ResponseEntity<List<Account>> list();

    /**
     * 保存
     * @param account
     * @return ResponseEntity
     */
    ResponseEntity save(Account account);
}
