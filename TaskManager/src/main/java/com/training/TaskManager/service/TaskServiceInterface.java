package com.training.TaskManager.service;

import com.training.TaskManager.model.TaskInfo;

public interface TaskServiceInterface 
{
	public void saveOrUpdate(TaskInfo tinfo,String enddate)throws Exception;
}
