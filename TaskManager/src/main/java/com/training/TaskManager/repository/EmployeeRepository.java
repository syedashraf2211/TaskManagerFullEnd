package com.training.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.training.TaskManager.model.EmployeeInfo;

public interface EmployeeRepository extends JpaRepository<EmployeeInfo,Integer>{

	EmployeeInfo findByEmail(String email);
}
