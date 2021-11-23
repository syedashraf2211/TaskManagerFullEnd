package com.training.TaskManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.TaskManager.model.EmployeeDTO;
import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.service.EmployeeService;
import com.training.TaskManager.service.ManagerService;

@Controller
public class HomeController 
{
	@Autowired
	EmployeeService eservice;
	
	@Autowired
	ManagerService mservice;
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/emp/elogin")
	public String employeeLogin()
	{
		return "elogin";
	}
	
	@RequestMapping("/eregister")
	public String registerEmployee()
	{
		return "eregistration";
	}
	
	@RequestMapping("/ecreate")
	public String createEmployee(@ModelAttribute EmployeeDTO einfo,Model m)
	{
		boolean status = eservice.saveOrUpdate(einfo);
		if(!status)
			m.addAttribute("message", "User Already Exist! Please login");
		return "elogin";
	}
	
	@RequestMapping("/mng/mlogin")
	public String managerLogin()
	{
		return "mlogin";
	}
	
	@RequestMapping("/mregister")
	public String createManager()
	{
		return "mregistration";
	}
	
	@RequestMapping("/mcreate")
	public String createManager(@ModelAttribute ManagerInfo minfo,Model m)
	{
		//System.out.println(minfo.getMname());
		boolean status = mservice.saveOrUpdate(minfo);
		if(!status)
			m.addAttribute("message", "User Already Exist! Please login");
		return "mlogin";
	}
}
