package com.dddinjava.portal.dao;

import com.dddinjava.portal.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CacheProperties cacheProperties;

    @Test
    void list() {
        Account account= accountMapper.list(3L);
        log.info(account.toString());
        assertNotNull(account);

        Account o = (Account) redisTemplate.opsForValue().get(cacheProperties.getRedis().getKeyPrefix() + "account::3");
        log.info(o.toString());
    }
}