package com.training.TaskManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.service.EmployeeService;
import com.training.TaskManager.service.ManagerService;

@Controller
public class HomeController 
{
	/*
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	*/
	@Autowired
	EmployeeService eservice;
	
	@Autowired
	ManagerService mservice;
	
	@RequestMapping("/")
	public String employeeLogin()
	{
		return "elogin";
	}
	
	@RequestMapping("/mlogin")
	public String managerLogin()
	{
		return "mlogin";
	}
	
	@RequestMapping("/evalidate")
	public String validateEmployee()
	{
		return "ehome";
	}
	
	@RequestMapping("/mvalidate")
	public String validateManager()
	{
		return "mhome";
	}
	
	@RequestMapping("/mregister")
	public String createManager()
	{
		return "mregistration";
	}
	
	@RequestMapping("/eregister")
	public String registerEmployee()
	{
		return "eregistration";
	}
	
	@RequestMapping("/ecreate")
	public String createEmployee(@ModelAttribute EmployeeInfo einfo)
	{
		//System.out.println(einfo.getEname());
		eservice.saveOrUpdate(einfo);
		return "elogin";
	}
	
	@RequestMapping("/mcreate")
	public String createManager(@ModelAttribute ManagerInfo minfo)
	{
		//System.out.println(minfo.getMname());
		mservice.saveOrUpdate(minfo);
		return "mlogin";
	}
	
	@RequestMapping("/tregister")
	public String registerTask()
	{
		List<EmployeeInfo> empdata;
		return "taskpage";
	}
}
