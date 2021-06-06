package com.dddinjava.portal.service.impl;

import com.dddinjava.portal.dao.UserDao;
import com.dddinjava.portal.entity.User;
import com.dddinjava.portal.service.UserDetailsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户逻辑层实现
 * @author zhaox
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @NonNull
    private UserDao userDao;
    /**
     * 根据用户名加载用户信息
     * @param s 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userDao.findByUsername(s);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("账户不存在");
        }
        return user;
    }
}
