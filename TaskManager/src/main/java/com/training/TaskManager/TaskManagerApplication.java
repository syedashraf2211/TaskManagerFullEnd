package com.training.TaskManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.model.TaskInfo;
import com.training.TaskManager.service.EmployeeService;
import com.training.TaskManager.service.ManagerService;

@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext cc = SpringApplication.run(TaskManagerApplication.class, args);
//		ManagerService managerservice = cc.getBean(ManagerService.class);
//		ManagerInfo manager = new ManagerInfo(33,"Manager","manager@gmail.com","12345");
//		managerservice.saveOrUpdate(manager);
//		EmployeeService empservice = cc.getBean(EmployeeService.class);
////		EmployeeInfo emp = new EmployeeInfo();
////		emp.setEid(1);
////		emp.setEname("Varshika");
////		emp.setEmail("vmymail@gmail.com");
////		emp.setPassword("112344556");
////		emp.setDesignation("Employee");
//		//empservice.saveOrUpdate(emp);
//		System.out.println(empservice.findByEmail("vmymail@gmail.com"));
	}

}
