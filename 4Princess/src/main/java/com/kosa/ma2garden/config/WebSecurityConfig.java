package com.kosa.ma2garden.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.requestMatchers(PathRequest.toStaticResources()
						.atCommonLocations());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login", "/singUp", "/access_denied", "/resources/**")
				.permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
				// USER, ADMIN 접근 허용
				.antMatchers("/userAccess")
				.hasRole("USER")
				.antMatchers("/userAccess")
				.hasRole("ADMIN")
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/user_access")
				.failureUrl("/access_denied") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보낸다.
				.and()
				.csrf()
				.disable(); // 로그인 창
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
