package com.training.TaskManager.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.model.TaskInfo;
import com.training.TaskManager.repository.TaskRepository;

@Service
public class TaskService implements TaskServiceInterface
{

	@Autowired
	EmployeeService eservice;
	
	@Autowired
	ManagerService mservice;
	
	@Autowired
	TaskRepository trepo;
	
	@Override
	public void saveOrUpdate(TaskInfo tinfo, String enddate,String email,String assignedby) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter1.parse(enddate);
		tinfo.setEndDate(date);
		EmployeeInfo empinfo = eservice.findByEmail(email);
		tinfo.setEmpinf(empinfo);
		ManagerInfo mnginfo = mservice.findByEmail(assignedby);
		tinfo.setMnginf(mnginfo);
		mservice.addTask(tinfo,mnginfo);
		eservice.addTask(tinfo,empinfo);
		trepo.save(tinfo);
		//System.out.println(eservice.findByEmail(email));
	}
	
	@Override
	public List<TaskInfo> getAllTasks() {
		// TODO Auto-generated method stub
		return trepo.findAll();
	}
	
}
