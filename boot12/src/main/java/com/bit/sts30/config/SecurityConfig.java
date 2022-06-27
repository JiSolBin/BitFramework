package com.bit.sts30.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// "/", "/login", "/logout" 만 접근 가능하고, 나머지 요청은 인증이 완료되어야 접근 가능
		http.authorizeHttpRequests().antMatchers("/", "/login", "/logout").permitAll();
		
		// "/hello", "/api/emp/**" 로 접근하려면 인증해야 됨
		// http.authorizeHttpRequests().antMatchers("/hello").authenticated();
		// http.authorizeHttpRequests().antMatchers("/api/emp/**").authenticated();
		// 위 세 개 제외 어디든 접근하려면 인증
		http.authorizeHttpRequests().anyRequest().authenticated();
		// 위 세 개 제외 어디든 접근하려면 "ADMIN" 권한 이어야 함
		// http.authorizeHttpRequests().anyRequest().hasRole("ADMIN");
		// 위 세 개 제외 어디든 접근하려면 "ADMIN", "USER" 권한 이어야 함
		// http.authorizeHttpRequests().anyRequest().hasAnyRole("ADMIN", "USER");
		
		http.formLogin().loginPage("/login");
		http.userDetailsService(userDetailsService);
	}

//	@Autowired
//	DataSource dataSource;

//	@Override
//	public void configure(AuthenticationManagerBuilder builder) throws Exception {
//		// insert username:dave/pw:1234
//		// 권한:USER
//		builder.jdbcAuthentication().dataSource(dataSource)
//			.withUser("admin").password(getPasswordEncoder().encode("1234")).roles("ADMIN");
//	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.jdbcAuthentication()
//			.dataSource(dataSource)
//			.usersByUsernameQuery("select username, password, enabled from users where username=?")
//			.authoritiesByUsernameQuery("select username, authority from authorities where username=?")
//		;
//	}
}
