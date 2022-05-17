package com.hyundai.board.config;

import lombok.extern.log4j.Log4j2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * @author 		: 고석준, 황명하 (Pair Programming)
 * @fileName 	: SecurityConfig.java
 * @date 		: 2022. 5. 14.
 * @description : 스프링 시큐리티 설정
 */
@Configuration
@Log4j2

public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//비밀번호 암호화 전용
   @Bean
   PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
   }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeHttpRequests()
			.antMatchers("/board/*").permitAll()
			.antMatchers("/member/login").permitAll()	//로그인 화면에 대해서는 권한없이 접근 가능 
			.antMatchers("/member/signup").permitAll()
			.antMatchers("/member/*").hasAnyRole("USER","ADMIN");
		
		
		http.formLogin().loginPage("/member/login").loginProcessingUrl("/login").defaultSuccessUrl("/board/list");
		
		http.csrf().disable();
		
		http.logout().logoutSuccessUrl("/board/list");
		
		http.oauth2Login().loginPage("/member/login").defaultSuccessUrl("/");
		
	}
   
   
}
