package com.dddinjava.portal.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * kaptcha配置
 * @author zhaox
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public ServletRegistrationBean registerServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new KaptchaServlet(), "/code");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_BORDER, "yes");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_BORDER_COLOR, "105,179,90");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_IMAGE_WIDTH, "120");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_IMAGE_HEIGHT, "44");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "blue");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "30");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "宋体,楷体,微软雅黑");
        return servletRegistrationBean;
    }


}
