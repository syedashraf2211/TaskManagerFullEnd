package com.training.TaskManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.model.TaskInfo;
import com.training.TaskManager.service.EmployeeService;
import com.training.TaskManager.service.ManagerService;
import com.training.TaskManager.service.TaskService;

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
	
	@Autowired
	TaskService tservice;
	
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
	public String registerTask(Model m)
	{
		List<EmployeeInfo> empdata = eservice.getAllEmployees();
		//System.out.println(empdata.get(0).getEname());
		m.addAttribute("empdata", empdata);
		return "tcreate";
	}
	
	@RequestMapping("/createtask")
	public String createTask(@ModelAttribute TaskInfo tinfo,@RequestParam String Enddate,@RequestParam String email) throws Exception
	{
		//System.out.println(email);
		tservice.saveOrUpdate(tinfo, Enddate,email);
		return "redirect:/mvalidate";
	}
}
