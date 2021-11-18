package com.training.TaskManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}

	@RequestMapping("/elogin")
	public String employeeLogin()
	{
		return "elogin";
	}
	
	@RequestMapping("/mlogin")
	public String managerLogin()
	{
		return "mlogin";
	}
	
	@RequestMapping("/logout")
	public String Logout()
	{
		return "redirect:/";
	}
}
