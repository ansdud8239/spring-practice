package com.douzone.container.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.user.User;

@Configuration
// 자동설정
@ComponentScan(basePackages={"com.douzone.container.user"})
public class AppConfig {
	
	// 수동설정 
	// 명시적
//	@Bean
//	public User user() {
//		return new User();
//	}
}
