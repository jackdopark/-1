package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.db.MemberManager;
import com.example.demo.vo.MemberVo;

@SpringBootApplication
public class BitSecurityApplication {

	//비밀번호 암호화를 위한 객체를 생성한다.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	public static void main(String[] args) {
		
		//MemberManager.insertMember(new MemberVo("tiger",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("tiger"),"홍길동","USER"));
		//MemberManager.insertMember(new MemberVo("master",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234"),"곽동길","ADMIN"));
		SpringApplication.run(BitSecurityApplication.class, args);
	}

}
