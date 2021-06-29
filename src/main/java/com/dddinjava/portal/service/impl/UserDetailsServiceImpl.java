package com.dddinjava.portal.service.impl;

import com.dddinjava.portal.entity.User;
import com.dddinjava.portal.mapper.UserMapper;
import com.dddinjava.portal.service.UserDetailsService;
import com.dddinjava.portal.wrapper.UserQuery;
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
    private UserMapper userMapper;
    /**
     * 根据用户名加载用户信息
     * @param s 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // 查询条件
        // select.xxx()指定需要查询的字段 .end()结束
        // where.yyy() 指定过滤条件 .end()结束
        UserQuery userQuery = userMapper.query()
                .select.id().username().password().enabled().end().
                        where.username().eq("admin").end();
        // 查询
        User user = userMapper.findOne(userQuery);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("账户不存在");
        }
        return user;
    }
}
