package com.training.TaskManager.service;

import java.util.List;

import com.training.TaskManager.model.TaskDTO;
import com.training.TaskManager.model.TaskInfo;

public interface TaskServiceInterface 
{
	public List<TaskInfo> getAllTasks();
	public void saveOrUpdate(TaskDTO tinfo,String enddate,String email,String assignedby)throws Exception;
	public TaskInfo getTask(int tid);
	public void deleteTask(int id);
	
	public void updateProgress(TaskDTO tinfo);
}
