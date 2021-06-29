package com.dddinjava.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhaox
 */
@SpringBootApplication
@EnableCaching
@ComponentScan("com.dddinjava.portal.entity")
@MapperScan("com.dddinjava.portal.mapper")
public class PortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

}

