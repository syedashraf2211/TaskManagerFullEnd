package com.training.TaskManager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.repository.ManagerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ManagerInfoTests 
{
	/*
	
	@Autowired
	ManagerRepository mrepo;
	
	@Test
	@Rollback(false)
	public void testSave()
	{
		ManagerInfo manager = new ManagerInfo(34,"Manager2","manager2@gmail.com","123456");
		System.out.println(mrepo);
		mrepo.save(manager);
		assertThat(mrepo.count()).isGreaterThan(1);
	}
	
	
//	@Test
//	public void testFindByEmail()
//	{
//		ManagerInfo manager = mrepo.findByEmail("manager@gmail.com");
//		assertThat(manager.getPassword()).isEqualTo("112344556");
//	}
	
*/
}
