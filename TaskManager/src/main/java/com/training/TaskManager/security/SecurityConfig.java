package com.training.TaskManager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.training.TaskManager.service.EmployeeService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	//@Configuration
	//@Order(1)
	//public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {
		
		@Autowired
		EmployeeService eservice;
		/*
	    public App1ConfigurationAdapter() {
	        super();
	    }
*/
	    @Bean
	    public AuthenticationProvider authProvider()
	    {
	    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	    	provider.setUserDetailsService(eservice);
	    	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	    	return provider;
	    }
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.antMatcher("/mng*")
	          .authorizeRequests()
	          .anyRequest()
	          .hasRole("MANAGER")
	          
	          .and()
	          .formLogin()
	          //.loginPage("/mlogin")
	          .defaultSuccessUrl("/mvalidate")
	          
//	          .and()
//	          .logout()
//	          .logoutUrl("/admin_logout")
//	          .logoutSuccessUrl("/protectedLinks")
//	          .deleteCookies("JSESSIONID")
	          
	          .and()
	          .exceptionHandling()
	          .accessDeniedPage("/403")
	          
	          .and()
	          .csrf().disable();
	    }
	    
	    /*
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        /*auth.inMemoryAuthentication()
	          .withUser("manager@email.com")
	          .password("manager")
	          .roles("MANAGER");
	    	
	    	//auth.authenticationProvider(authProvider);
	    	
	    }
		*/
	    
	   
	//}
	/*
	@Configuration
	@Order(2)
	public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {

		@Autowired
		CustomAuthenticationProvider authProvider;
		
	    public App2ConfigurationAdapter() {
	        super();
	    }

	    protected void configure(HttpSecurity http) throws Exception {
	        http.antMatcher("/emp*")
	          .authorizeRequests()
	          .anyRequest()
	          .hasRole("EMPLOYEE")
	          
	          .and()
	          .formLogin()
	          .loginPage("/")
	          //.loginProcessingUrl("/")
	          .defaultSuccessUrl("/evalidate")
	          
//	          .and()
//	          .logout()
//	          .logoutUrl("/user_logout")
//	          .logoutSuccessUrl("/protectedLinks")
//	          .deleteCookies("JSESSIONID")
	          
	          .and()
	          .exceptionHandling()
	          .accessDeniedPage("/403")
	          
	          .and()
	          .csrf().disable();
	    }
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        /*auth.inMemoryAuthentication()
	          .withUser("employee1@gmail.com")
	          .password("employee")
	          .roles("EMPLOYEE");
	    	auth.authenticationProvider(authProvider);
	    }
	}*/
}