package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration		//자동으로 스캔되어야 하므로 컨피그래이션을 적는다
@EnableWebSecurity	// 어노테이션 기반의 시큐리티 설정임을 나타낸다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		http.authorizeRequests()
		.mvcMatchers("/","/all/**").permitAll()
		.mvcMatchers("/","/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated();
		//1번째 줄 사용자의 요청별 권한 설정을 할때 쓴다
		//2번째 줄 이러한 요청들은 아무나 사용할 수 있다.
		//3번째 줄 이러한 요청들은 관리자 권한 (ADMIN role)이 있어야 사용할 수 있다.
		//4번째 줄 나머지 요청들은 인증만 있으면 된다.
	
		http.formLogin();	//스프링 시큐리티가 제공하는 로그인폶을 사용하겠다.
		http.httpBasic();	//http기본 프로토콜을 사용하겠다.
	}
	
}