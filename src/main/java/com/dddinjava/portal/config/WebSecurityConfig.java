package com.dddinjava.portal.config;

import com.dddinjava.portal.filter.VerificationCodeFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * HttpSecurity配置
 *
 * @author zhaox
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // url放行
                .antMatchers("/code").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 登录成功Handler
                .successHandler(new AuthenticationSuccessHandler())
                // 登录失败Handler
                .failureHandler(new AuthenticationFailureHandler())
                .and()
                .csrf().disable()
                .addFilterBefore(new VerificationCodeFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
