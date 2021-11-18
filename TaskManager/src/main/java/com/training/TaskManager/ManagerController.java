package com.training.TaskManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.ManagerInfo;
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
	

	@RequestMapping("/mvalidate")
	public String validateManager(Model m)
	{
		List<TaskInfo> tinfo= tservice.getAllTasks();
		//ManagerInfo mnginfo = mservice.findByEmail("mmail");
		//System.out.println(mnginfo.getMid());
		m.addAttribute("tinfo",tinfo);
		return "mhome";
	}
	
	@PostMapping("/mvalidate")
	public String postManager(Model m,@RequestParam String email)
	{
		//System.out.println(minfo.getEmail());
		List<TaskInfo> tinfo= tservice.getAllTasks();
		m.addAttribute("tinfo",tinfo);
		m.addAttribute("mmail",email);
		return "mhome";
	}
	
	@RequestMapping("/mregister")
	public String createManager()
	{
		return "mregistration";
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
	public String createTask(@ModelAttribute TaskInfo tinfo,@RequestParam String Enddate,@RequestParam String email,@RequestParam String AssignedBy) throws Exception
	{
		//  System.out.println(AssignedBy);
		tservice.saveOrUpdate(tinfo, Enddate,email,AssignedBy);
		return "redirect:/mng/mvalidate";
	}
	
	@RequestMapping(value = "/updatetask/{taskId:[\\d]+}",method = RequestMethod.GET)
	public String updateTask(@PathVariable("taskId") int tid,Model m) throws Exception
	{
		//System.out.println(tid);
		TaskInfo tinfo = tservice.getTask(tid);
		m.addAttribute("tinfo",tinfo);
		return "utask";
	}
	
	@RequestMapping(value = "/deletetask/{taskId:[\\d]+}",method = RequestMethod.GET)
	public String deleteTask(@PathVariable("taskId") int tid,Model m) throws Exception
	{
		//System.out.println(tid);
		tservice.deleteTask(tid);
		
		return "redirect:/mng/mvalidate";
	}
}
