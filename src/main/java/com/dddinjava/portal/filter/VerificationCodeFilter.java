package com.dddinjava.portal.filter;

import com.dddinjava.portal.util.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.code.kaptcha.Constants;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * 验证码校验
 * @author zhaox
 */
public class VerificationCodeFilter extends OncePerRequestFilter {
    /**
     * 登录地址
     */
    private final static String LOGIN_URL = "/login";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        // 非登录请求不处理
        if (!LOGIN_URL.equals(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 获取验证码
        String requestCode = request.getParameter("code");

        HttpSession session = request.getSession();

        String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (!StringUtils.hasLength(requestCode) || !StringUtils.hasLength(code)
                || !requestCode.equals(code)) {
            responseResult(response, session, "验证码错误");
            return;
        }


        // 判断验证码是否超时
        Date date = (Date)session.getAttribute(Constants.KAPTCHA_SESSION_DATE);
        long codeTime = date.getTime();
        if (Long.compare(codeTime, System.currentTimeMillis()) == 1) {
            responseResult(response, session, "验证码过期");
            return;
        }

        filterChain.doFilter(request, response);

    }

    /**
     * 响应
     * @param response
     * @param session
     * @param errorMessage
     * @throws IOException
     */
    private void responseResult(HttpServletResponse response, HttpSession session, String errorMessage) throws IOException {
        ResponseResult responseResult = new ResponseResult<>(errorMessage);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        mapper.writeValue(response.getWriter(), responseResult);

        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        session.removeAttribute(Constants.KAPTCHA_SESSION_DATE);
    }
}
