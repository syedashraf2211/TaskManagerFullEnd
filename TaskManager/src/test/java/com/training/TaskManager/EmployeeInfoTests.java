package com.training.TaskManager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.repository.EmployeeRepository;
import com.training.TaskManager.service.EmployeeService;
import com.training.TaskManager.service.EmployeeServiceInterface;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmployeeInfoTests 
{
	
	@Autowired
	EmployeeRepository empservice;
	
	
	
	@Test
	public void testFindByEmail()
	{
		EmployeeInfo emp = empservice.findByEmail("vijay.vegnesh@gmail.com");
		assertThat(emp.getPassword()).isEqualTo("123");
	}
 
}
