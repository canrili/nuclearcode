package com.dddinjava.portal.service.impl;

import com.dddinjava.portal.dao.AccountMapper;
import com.dddinjava.portal.entity.Account;
import com.dddinjava.portal.service.AccountService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
        return ResponseEntity.status(list.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK).body(list);
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

    /**
     * 修改
     *
     * @param account
     * @return
     */
    @Override
    public ResponseEntity update(Account account) {
        int count = accountMapper.update(account);
        return ResponseEntity.status(count > 0 ? HttpStatus.OK: HttpStatus.ACCEPTED).build();
    }

    /**
     * 根据id 删除
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity delete(Long id) {
        int count = accountMapper.delete(id);
        return ResponseEntity.status(count > 0 ? HttpStatus.OK: HttpStatus.ACCEPTED).build();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity findById(Long id) {
        Account account = accountMapper.findById(id);
        return ResponseEntity.status(Objects.isNull(account) ? HttpStatus.NO_CONTENT : HttpStatus.OK).body(account);
    }
}
