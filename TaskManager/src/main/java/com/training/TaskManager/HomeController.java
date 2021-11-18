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
	
}
