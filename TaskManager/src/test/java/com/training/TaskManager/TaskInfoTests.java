package com.training.TaskManager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.model.TaskInfo;
import com.training.TaskManager.repository.EmployeeRepository;
import com.training.TaskManager.repository.ManagerRepository;
import com.training.TaskManager.repository.TaskRepository;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TaskInfoTests 
{

	
	//@Autowired
	//private TaskRepository taskrepo;
	
//	@Autowired
//	private EmployeeRepository emprepo;
//	
//	@Autowired
//	private ManagerRepository managerrepo;
	
	//@Test
//	public void testSave()
//	{
//		EmployeeInfo emp = emprepo.findByEmail("vmymail@gmail.com");
//		ManagerInfo manager = managerrepo.findByEmail("manager@gmail.com");
//		TaskInfo taskinfo = new TaskInfo(5,"xyz","description",30,new Date(),new Date(),emp,manager);
//		emp.getTasks().add(taskinfo);
//		manager.getTasks().add(taskinfo);
//		emprepo.save(emp);
//		managerrepo.save(manager);
//		System.out.println(taskrepo);
//		taskrepo.save(taskinfo);
//		assertThat(taskrepo.count()).isGreaterThan(1);
//	}
}
