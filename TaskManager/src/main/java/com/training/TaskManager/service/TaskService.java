package com.training.TaskManager.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.model.TaskDTO;
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
	public void saveOrUpdate(TaskDTO tinfo, String enddate,String email,String assignedby) throws Exception {

		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter1.parse(enddate);
		tinfo.setEndDate(date);
		EmployeeInfo empinfo = eservice.findByEmail(email);
		tinfo.setEmpinf(empinfo);
		ManagerInfo mnginfo = mservice.findByEmail(assignedby);
		tinfo.setMnginf(mnginfo);
		TaskInfo taskinfo = tinfo.toEntity(tinfo);
		mservice.addTask(taskinfo,mnginfo);
		eservice.addTask(taskinfo,empinfo);
		trepo.save(taskinfo);
		
	}
	
	@Override
	public List<TaskInfo> getAllTasks() {

		return trepo.findAll();
	}

	@Override
	public TaskInfo getTask(int tid) {

		return trepo.getById(tid);
	}
	
	@Override
	public void deleteTask(int id) {

		TaskInfo tinfo = getTask(id);
		
		eservice.deleteTask(tinfo, tinfo.getEmpinf());
		mservice.deleteTask(tinfo, tinfo.getMnginf());
		
		trepo.deleteById(id);
		
	}

	@Override
	public void updateProgress(TaskDTO ut) {

		TaskInfo tinfo = getTask(ut.getTaskId());
		tinfo.setProgress(ut.getProgress());
		
		mservice.addTask(tinfo,tinfo.getMnginf());
		eservice.addTask(tinfo,tinfo.getEmpinf());
		trepo.save(tinfo);
	}
	
	
}
