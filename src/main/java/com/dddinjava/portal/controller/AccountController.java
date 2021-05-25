package com.dddinjava.portal.controller;

import com.dddinjava.portal.entity.Account;
import com.dddinjava.portal.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 保存
     * @param account
     * @return
     */
    @PostMapping
    public ResponseEntity save(@RequestBody Account account) {
        return accountService.save(account);
    }

    /**
     * 修改
     * @param account
     * @return
     */
    @PutMapping
    public ResponseEntity update(@RequestBody Account account) {
        return accountService.update(account);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return accountService.delete(id);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        return accountService.findById(id);
    }
}
