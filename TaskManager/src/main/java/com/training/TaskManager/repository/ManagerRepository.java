package com.training.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.TaskManager.model.ManagerInfo;

public interface ManagerRepository extends JpaRepository<ManagerInfo,Integer>
{
	ManagerInfo findByEmail(String email);
}
