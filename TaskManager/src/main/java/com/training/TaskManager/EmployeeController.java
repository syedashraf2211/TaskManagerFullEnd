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
import org.springframework.web.bind.support.SessionStatus;

import com.training.TaskManager.model.EmployeeDTO;
import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.TaskDTO;
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
	
	final String TINFO = "tinfo";
	
	
	@RequestMapping("/evalidate")
	public String validateEmployee(Model m)
	{
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		List<TaskInfo> tinfo= tservice.getAllTasks();
		m.addAttribute(TINFO,tinfo);
		m.addAttribute("empmail", email);
		return "ehome";
	}
	
	@PostMapping("/evalidate")
	public String validateEmployee(@RequestParam String email,Model m)
	{
		List<TaskInfo> tinfo= tservice.getAllTasks();
		m.addAttribute(TINFO,tinfo);
		m.addAttribute("empmail", email);
		return "ehome";
	}
	
	
	@RequestMapping("/ecreate")
	public String createEmployee(@ModelAttribute EmployeeDTO einfo,Model m)
	{
		boolean status = eservice.saveOrUpdate(einfo);
		if(!status)
			m.addAttribute("message", "User Already Exist! Please login");
		return "elogin";
	}
	
	@RequestMapping("/ecreatetask")
	public String ecreateTask(@ModelAttribute TaskDTO tinfo)
	{
		tservice.updateProgress(tinfo);
		return "redirect:/emp/evalidate";
	}
	
	@RequestMapping(value = "/eupdatetask/{taskId:[\\d]+}")
	public String eupdateTask(@PathVariable("taskId") int tid,Model m)
	{
		TaskInfo tinfo = tservice.getTask(tid);
		m.addAttribute(TINFO,tinfo);
		return "eutask";
	}
	
	@RequestMapping(value="/end")
	public void endSession(SessionStatus status)
	{
		status.setComplete();
	}
}
