package com.training.TaskManager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@Order(2)
public class Config2 extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
	private MyUserDetailsService userdetailsservice;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userdetailsservice).passwordEncoder(passwordEncoder());
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/emp/**")
			.authorizeRequests().anyRequest().authenticated()
			.and().formLogin().loginPage("/emp/elogin")
				.defaultSuccessUrl("/emp/evalidate", true)
			.permitAll()
			.and().logout().logoutUrl("/emp/logout").logoutSuccessUrl("/");
		
		http.csrf().disable();
	}
}
