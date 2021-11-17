package com.training.TaskManager.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.training.TaskManager.service.EmployeeService;
import com.training.TaskManager.service.ManagerService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider 
{

	//private static Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	EmployeeService eservice;
	
	@Autowired
	ManagerService mservice;
	
	public Authentication authenticate(Authentication authentication )
	{
		
		
	    String userName = authentication.getName().trim();
	    String password = authentication.getCredentials().toString().trim();
	    Authentication auth = null;
	    String role=null;
	    if(eservice.findByEmail(userName).getPassword().equals(password))
	    {
	    	role = "EMPLOYEE";
	    }
	    
	    else if(mservice.findByEmail(userName).getPassword().equals(password))
	    {
	    	role = "MANAGER";
	    }
	    /*
	    //Authenticate the user based on your custom logic
	    String  role = login.getApplicationRole(userName, password, "ADMIN","DEVELOPER");
		*/
	    if (role != null)
	    {
	
	        Collection<? extends GrantedAuthority> grantedAuths = Collections.singleton(new SimpleGrantedAuthority(role.trim()));
	
	        ApplicationUser appUser = new ApplicationUser(userName,password, true, true, true, true,grantedAuths);
	
	        //return new UsernamePasswordAuthenticationToken(userName,password,grantedAuths);
	        auth = new UsernamePasswordAuthenticationToken(appUser, password, grantedAuths);
	
	            return auth;
	        }
	        else 
	        {
	          return null;
	        }
		//return auth;
	    }
	
	    @Override
	    public boolean supports(Class<? extends Object> authentication) 
	    {
	        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	    }
}