package com.training.TaskManager.service;

import java.util.List;

import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.model.TaskInfo;

public interface ManagerServiceInterface 
{
	public void saveOrUpdate(ManagerInfo manager);
	
	public ManagerInfo findByEmail(String email);
	
	public void addTask(TaskInfo tinfo,ManagerInfo minfo);
	
	public void deleteTask(TaskInfo tinfo,ManagerInfo minfo);
}
