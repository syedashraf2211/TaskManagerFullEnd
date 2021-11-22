package com.training.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.model.TaskInfo;
import com.training.TaskManager.repository.ManagerRepository;
import com.training.TaskManager.repository.TaskRepository;

@Service
public class ManagerService implements ManagerServiceInterface{

	@Autowired
	private ManagerRepository managerrepo;
	
	@Autowired
	private TaskRepository taskrepo;
	
	@Override
	public boolean saveOrUpdate(ManagerInfo manager) 
	{
		ManagerInfo minfo = findByEmail(manager.getEmail());
		if(minfo != null)
			return false;
		String password = manager.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedpassword = passwordEncoder.encode(password);
		manager.setPassword(encodedpassword);
		managerrepo.save(manager);
		return true;
	}

	@Override
	public ManagerInfo findByEmail(String email) {
		
		ManagerInfo manager = managerrepo.findByEmail(email);
		return manager;
	}
	
	public boolean validateCredentials(String email, String password)
	{
		ManagerInfo manager = findByEmail(email);
		return (manager.getEmail().equals(email)&& manager.getPassword().equals(password));
	}
	
	public void saveTask(TaskInfo task)
	{
		taskrepo.save(task);
	}

	@Override
	public void addTask(TaskInfo tinfo, ManagerInfo minfo) {
		// TODO Auto-generated method stub
		minfo.getTasks().add(tinfo);
	}

	@Override
	public void deleteTask(TaskInfo tinfo, ManagerInfo minfo) {
		// TODO Auto-generated method stub
		minfo.getTasks().remove(tinfo);
	}

	

}
