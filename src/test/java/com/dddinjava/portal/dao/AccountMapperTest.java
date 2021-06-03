package com.dddinjava.portal.dao;

import com.dddinjava.portal.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    void list() {
        List<Account> list = accountMapper.list(3L);
        log.info(list.toString());
        assertEquals(1, list.size());
    }
}