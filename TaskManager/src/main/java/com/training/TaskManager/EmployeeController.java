package com.training.TaskManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.TaskInfo;
import com.training.TaskManager.service.EmployeeService;
import com.training.TaskManager.service.TaskService;

@Controller
@SessionAttributes({"empmail"})
@RequestMapping("/emp")
public class EmployeeController 
{
	@Autowired
	EmployeeService eservice;
	
	@Autowired
	TaskService tservice;
	
	@RequestMapping("/elogin")
	public String employeeLogin()
	{
		return "elogin";
	}
	
	//@PreAuthorize("hasRole('EMPLOYEEee')")
	@RequestMapping("/evalidate")
	public String validateEmployee(Model m)
	{
		//System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		List<TaskInfo> tinfo= tservice.getAllTasks();
		m.addAttribute("tinfo",tinfo);
		m.addAttribute("empmail", email);
		return "ehome";
	}
	
	@PostMapping("/evalidate")
	public String validateEmployee(@RequestParam String email,Model m)
	{
		List<TaskInfo> tinfo= tservice.getAllTasks();
		m.addAttribute("tinfo",tinfo);
		m.addAttribute("empmail", email);
		return "ehome";
	}
	
	
	
	@RequestMapping("/ecreate")
	public String createEmployee(@ModelAttribute EmployeeInfo einfo)
	{
		//System.out.println(einfo.getEname());
		eservice.saveOrUpdate(einfo);
		return "elogin";
	}
	
	@RequestMapping("/ecreatetask")
	public String ecreateTask(@ModelAttribute TaskInfo tinfo) throws Exception
	{
		System.out.println(tinfo.getProgress());
		tservice.updateProgress(tinfo);
		return "redirect:/emp/evalidate";
	}
	
	@RequestMapping(value = "/eupdatetask/{taskId:[\\d]+}",method = RequestMethod.GET)
	public String eupdateTask(@PathVariable("taskId") int tid,Model m) throws Exception
	{
		//System.out.println(tid);
		
		TaskInfo tinfo = tservice.getTask(tid);
		m.addAttribute("tinfo",tinfo);
		return "eutask";
	}
}
