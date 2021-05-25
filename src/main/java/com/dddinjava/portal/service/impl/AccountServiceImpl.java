package com.dddinjava.portal.service.impl;

import com.dddinjava.portal.dao.AccountMapper;
import com.dddinjava.portal.entity.Account;
import com.dddinjava.portal.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 帐户逻辑层实现
 * @author zhaox
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    /**
     * 查询所有帐户
     *
     * @return
     */
    @Override
    public ResponseEntity<List<Account>> list() {
        List<Account> list = accountMapper.list();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    /**
     * 保存
     *
     * @param account
     * @return ResponseEntity
     */
    @Override
    public ResponseEntity save(Account account) {
        int count = accountMapper.save(account);
        return ResponseEntity.status(count > 0 ? HttpStatus.CREATED: HttpStatus.ACCEPTED).build();
    }
}
