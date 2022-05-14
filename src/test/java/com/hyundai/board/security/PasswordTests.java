package com.hyundai.board.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 		: 황명하
 * @fileName 	: PasswordTests.java
 * @date 		: 2022. 5. 14.
 * @description : 
 */
@SpringBootTest
public class PasswordTests {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
   public void testEncide(){
       String password ="1111";
       String enPw = passwordEncoder.encode(password);
       System.out.println("enpw" + enPw);
       boolean matchResult = passwordEncoder.matches(password,enPw);
       System.out.println("matchResult: " + matchResult);
	}
	
}
