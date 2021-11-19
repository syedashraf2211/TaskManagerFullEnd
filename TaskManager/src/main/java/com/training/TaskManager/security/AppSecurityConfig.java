package com.training.TaskManager.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

//@Configuration

public class AppSecurityConfig
{
	//@Order(1)
	//@Configuration
	//@EnableWebSecurity
	public static class Config1 extends WebSecurityConfigurerAdapter
	{
		@Autowired
		private MyUserDetailsService userdetailsservice;
	
		@Bean
		public AuthenticationProvider authProvider()
		{
			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
			provider.setUserDetailsService(userdetailsservice);
			provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
			
			return provider;
		}
		@Override
		public void configure(WebSecurity web) {
		    web.ignoring()
		        .antMatchers("/**/*.{js,html,css}");
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception 
		{
			/*
			http
			.antMatcher("/emp/**")
	        .authorizeRequests()
	        .anyRequest().authenticated()
	        
	        .and()
	        .formLogin()
	        .loginPage("/elogin")
	        .defaultSuccessUrl("/emp/evalidate",true)
	        
	        .and()
	        .logout()
	        .logoutSuccessUrl("/")
	        
	        .and()
	        .exceptionHandling()
	        .accessDeniedPage("/")
	        
	        .and()
	        .csrf().disable();
			*/
			
			http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/","/eregister","/mregister","/mlogin","/mng/**").permitAll()
				.antMatchers("/elogin").hasRole("USER")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/elogin").permitAll()
				.defaultSuccessUrl("/emp/evalidate",true)
				.and()
				.logout()
				.logoutSuccessUrl("/").permitAll();
				
		}
	}
	/*
	@Order(2)
	@Configuration
	@EnableWebSecurity
	public static class Config2 extends WebSecurityConfigurerAdapter
	{
//	@Autowired
//	private ManagerDetailsService userdetailsservice1;
	/*
	@Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String username = authentication.getName();
                String password = authentication.getCredentials().toString();
                if (username.equals("username") && password.equals("password")) {
                    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                    return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
                }
                throw new AuthenticationServiceException("Invalid credentials.");
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return authentication.equals(UsernamePasswordAuthenticationToken.class);
            }
        });
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.antMatcher("/mng/**")
        .authorizeRequests()
        .anyRequest().authenticated()
        
        .and()
        .formLogin()
        .loginPage("/mlogin")
        .defaultSuccessUrl("/mng/mvalidate",true).permitAll()
        
        .and()
        .logout()
        .logoutSuccessUrl("/")
        
        .and()
        .exceptionHandling()
        .accessDeniedPage("/")
        
        .and()
        .csrf().disable();
		/*
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/mlogin").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/mlogin").permitAll()
			.defaultSuccessUrl("/mvalidate",true)
			.and()
			.logout()
			.logoutSuccessUrl("/logout").permitAll();
		
	}
	*/
//		@Override
//		public void configure(AuthenticationManagerBuilder auth) throws Exception {
//			auth.inMemoryAuthentication()
//				.withUser("user@gmail.com").password("{noop}password").roles("ADMIN");
//		}
//
//		@Override
//		public void configure(HttpSecurity http) throws Exception {
//			http
//				.antMatcher("/mng/**")
//				.authorizeRequests().anyRequest().authenticated()
//				.and().formLogin().loginPage("/mlogin")
//					.defaultSuccessUrl("/mng/mvalidate/", true)
//				.permitAll()
//				.and().logout().logoutSuccessUrl("/login");
//			
//			http.csrf().disable();
//		}
	//}
}