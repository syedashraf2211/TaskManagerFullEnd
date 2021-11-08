package com.training.TaskManager.service;

import com.training.TaskManager.model.ManagerInfo;

public interface ManagerServiceInterface 
{
	public void saveOrUpdate(ManagerInfo manager);
	
	public ManagerInfo findByEmail(String email);
}
