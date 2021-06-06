package com.dddinjava.portal.config;

import com.dddinjava.portal.entity.User;
import com.dddinjava.portal.util.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理
 * @author zhaox
 */
@Slf4j
public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        String message = e.getMessage();

        log.info("登录失败 => {}", message);
        ResponseResult responseResult = new ResponseResult<>(message);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), responseResult);
    }
}
