package com.dddinjava.portal.controller;

import com.dddinjava.portal.entity.Account;
import com.dddinjava.portal.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 帐户控制层
 * @author zhaox
 */
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AccountController {

    private final AccountService accountService;

    /**
     * 查询所有帐户
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Account>> list() {
        return accountService.list();
    }

}
