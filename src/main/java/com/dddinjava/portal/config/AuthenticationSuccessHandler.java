package com.dddinjava.portal.config;

import com.dddinjava.portal.entity.User;
import com.dddinjava.portal.util.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理
 * @author zhaox
 */
@Slf4j
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        log.info("登录成功 => {}", authentication.getName());

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        // 获取当前登录人的信息
        Object principal = authentication.getPrincipal();
        ObjectMapper mapper = new ObjectMapper();

        if (principal instanceof User) {
            User user = (User)principal;
            user.setPassword(null);
            ResponseResult<User> responseResult = new ResponseResult<User>("登录成功", user);
            mapper.writeValue(response.getWriter(), responseResult);

        } else {
            ResponseResult<Object> responseResult = new ResponseResult<>("登录成功", principal);
            mapper.writeValue(response.getWriter(), responseResult);
        }

    }
}
