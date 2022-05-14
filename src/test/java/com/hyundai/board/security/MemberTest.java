package com.hyundai.board.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hyundai.board.domain.MemberVO;
import com.hyundai.board.mapper.MemberMapper;

import java.sql.SQLException;
 
@SpringBootTest
public class MemberTest {
   @Autowired
   private MemberMapper memberMapper;
   //암호화된 데이터 입력 위해
   @Autowired
   private PasswordEncoder passwordEncoder;
 
   @Test
   public void insertDummies() throws SQLException{
       //패스워드는 1111 로 고정
       for(int i =11; i <= 50; i++) {
           MemberVO member = new MemberVO();
           member.setMid("user"+i);
           member.setMname("이름"+i);
           String pw = "user" + i;
           member.setMpassword(passwordEncoder.encode(pw));
           member.setMemail("user"+i+"@email.com");
           if(i<=40) member.setMrole("ROLE_MEMBER");
           else member.setMrole("ROLE_ADMIN");
           memberMapper.insertMember(member);
       };//end int
 
       System.out.println("입력 성공");
   }//end insert..
}//end class
