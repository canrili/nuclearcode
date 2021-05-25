package com.dddinjava.portal.dao;

import com.dddinjava.portal.entity.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    @DisplayName("保存")
    void save() {
        Account account = new Account("dddinjava", "123", "dddinjava");
        Long count = accountMapper.save(account);
        assertEquals(1, count);
    }

    @Test
    @DisplayName("查询所有")
    void list() {
        List<Account> list = accountMapper.list();
        assertEquals(2, list.size());
    }
}