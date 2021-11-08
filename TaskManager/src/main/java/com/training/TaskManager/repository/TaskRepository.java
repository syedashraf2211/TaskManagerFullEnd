package com.training.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.TaskManager.model.TaskInfo;

public interface TaskRepository extends JpaRepository<TaskInfo,Integer>
{
	
}
