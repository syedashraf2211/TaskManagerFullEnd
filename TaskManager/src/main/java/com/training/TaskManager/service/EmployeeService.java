package com.training.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.TaskInfo;
import com.training.TaskManager.repository.EmployeeRepository;
import com.training.TaskManager.repository.TaskRepository;

@Service
@Component
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeRepository repo;
	
	
	
	@Override
	public boolean saveOrUpdate(EmployeeInfo emp) {
		/*
		System.out.println(emp.getEmail());
		EmployeeInfo empdata = findByEmail(emp.getEmail());
		System.out.println(empdata);
		if(empdata.getEmail()!=null)
			return false;
			*/
		repo.save(emp);
		return true;
	}



	@Override
	public List<EmployeeInfo> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	@Override
	public EmployeeInfo findByEmail(String email) {
		// TODO Auto-generated method stub
		EmployeeInfo emp = repo.findByEmail(email);
		return emp;
	}



	@Override
	public void addTask(TaskInfo tinfo,EmployeeInfo empinfo) {
		// TODO Auto-generated method stub
		empinfo.getTasks().add(tinfo);
	}



	@Override
	public void deleteTask(TaskInfo tinfo, EmployeeInfo empinfo) {
		// TODO Auto-generated method stub
		//System.out.println(empinfo.getTasks().size());
		empinfo.getTasks().remove(tinfo);
		//System.out.println(empinfo.getTasks().size());
		
	}

	
	/*
	public boolean validateEmployee(String email,String password)
	{
		EmployeeInfo emp = findByEmail(email);
		return (emp.getEmail().equals(email) && emp.getPassword().equals(password));
		
	}*/
}
