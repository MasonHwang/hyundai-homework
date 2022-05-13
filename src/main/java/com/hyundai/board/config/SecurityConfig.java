package com.hyundai.board.config;

import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2

public class SecurityConfig extends WebSecurityConfigurerAdapter{

//		//비밀번호 암호화 전용
//	   @Bean
//	   PasswordEncoder passwordEncoder(){
//	       return new BCryptPasswordEncoder();
//	   }
}
