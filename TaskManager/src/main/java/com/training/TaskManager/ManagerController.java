package com.training.TaskManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.model.TaskDTO;
import com.training.TaskManager.model.TaskInfo;
import com.training.TaskManager.service.EmployeeService;
import com.training.TaskManager.service.ManagerService;
import com.training.TaskManager.service.TaskService;

@Controller
@SessionAttributes({"mmail"})
@RequestMapping("/mng")
public class ManagerController 
{
	
	@Autowired
	EmployeeService eservice;
	
	@Autowired
	ManagerService mservice;
	
	@Autowired
	TaskService tservice;
	
	final String TINFO = "tinfo";

	@RequestMapping("/mvalidate")
	public String validateManager(Model m)
	{
		List<TaskInfo> tinfo= tservice.getAllTasks();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		m.addAttribute("mmail", email);
		m.addAttribute(TINFO,tinfo);
		return "mhome";
	}
	
	@PostMapping("/mvalidate")
	public String postManager(Model m,@RequestParam String email)
	{
		List<TaskInfo> tinfo= tservice.getAllTasks();
		m.addAttribute(TINFO,tinfo);
		m.addAttribute("mmail",email);
		return "mhome";
	}
	
	
	@RequestMapping("/tregister")
	public String registerTask(Model m)
	{
		List<EmployeeInfo> empdata = eservice.getAllEmployees();
		m.addAttribute("empdata", empdata);
		return "tcreate";
	}
	
	@RequestMapping("/createtask")
	public String createTask(@ModelAttribute TaskDTO tinfo,@RequestParam String Enddate,@RequestParam String email,@RequestParam String AssignedBy) throws Exception
	{
		tservice.saveOrUpdate(tinfo, Enddate,email,AssignedBy);
		return "redirect:/mng/mvalidate";
	}
	
	@RequestMapping(value = "/updatetask/{taskId:[\\d]+}")
	public String updateTask(@PathVariable("taskId") int tid,Model m)
	{
		TaskInfo tinfo = tservice.getTask(tid);
		m.addAttribute(TINFO,tinfo);
		return "utask";
	}
	
	@RequestMapping(value = "/deletetask/{taskId:[\\d]+}")
	public String deleteTask(@PathVariable("taskId") int tid,Model m)
	{
		tservice.deleteTask(tid);
		
		return "redirect:/mng/mvalidate";
	}
	
	@RequestMapping(value="/end")
	public void endSession(SessionStatus status)
	{
		status.setComplete();
	}
}
