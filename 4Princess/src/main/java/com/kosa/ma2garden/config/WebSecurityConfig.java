package com.kosa.ma2garden.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	final JwtTokenProvider jwtTokenProvider;

	// authenticationManager를 Bean 등록합니다.
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
				.disable()
				.httpBasic()
				.disable() // rest api 만을 고려하여 기본 설정은 해제하겠습니다.
				.csrf()
				.disable()
				.formLogin()
				.disable()
				.headers()
				.frameOptions()
				.disable()
				.and()
				.authorizeRequests() // 요청에 대한 사용권한 체크
				.antMatchers("/admin/**")
				.hasRole("ADMIN")
				.antMatchers("/member/**")
				.hasRole("USER")
				.anyRequest()
				.permitAll() // 그외 나머지 요청은 누구나 접근 가능
				.and()
				.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
						UsernamePasswordAuthenticationFilter.class)
				.sessionManagement() // Security에서 기본 지원하는 Sessin설정 해제
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter 전에 넣는다
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("*");
		configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
		configuration.addAllowedHeader("*");
		configuration.setAllowCredentials(true);
		configuration.setMaxAge(3600L);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
