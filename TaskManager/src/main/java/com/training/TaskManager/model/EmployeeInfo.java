package com.training.TaskManager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class EmployeeInfo 
{
	@Id
	@GeneratedValue
	private int Eid;
	public String Ename;
	private String Email;
	private String Password;
	private String Designation;
	/*
	@OneToOne(mappedBy = "TaskInfo")
    private TaskInfo taskinfo;
	*/
	/*
	@OneToMany(mappedBy = "empinf")
	private List<TaskInfo> tasks = new ArrayList<>();
	
	public List<TaskInfo> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<TaskInfo> tasks) {
		this.tasks = tasks;
	}
	*/
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	
	
}
