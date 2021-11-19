package com.training.TaskManager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(1)
public class Config1 extends WebSecurityConfigurerAdapter {
	/*
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin@gmail.com").password("{noop}password").roles("ADMIN");
	}
	*/
	
	@Autowired
	private ManagerDetailsService managerdetailsservice;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(managerdetailsservice).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.antMatcher("/mng/**")
		.authorizeRequests().anyRequest().authenticated()
		.and().formLogin().loginPage("/mng/mlogin")
			.defaultSuccessUrl("/mng/mvalidate", true)
		.permitAll()
		.and().
		logout().logoutUrl("/mng/logout").logoutSuccessUrl("/");
		/*logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/").deleteCookies("JSESSIONID")
		.invalidateHttpSession(true); */
	http.csrf().disable();

	}
}	
