package com.training.TaskManager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class EmployeeInfo implements Serializable
{
	@Id
	@GeneratedValue

	private int eid;
	private String ename;
	private String email;
	private String password;
	private String designation;

	
	@OneToMany(mappedBy = "empinf")
	private List<TaskInfo> tasks = new ArrayList<>();
	
	public EmployeeInfo() {
		super();
	}

	public EmployeeInfo(String ename, String email, String password, String designation) {
		super();
		this.ename = ename;
		this.email = email;
		this.password = password;
		this.designation = designation;
	}

	public List<TaskInfo> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<TaskInfo> tasks) {
		this.tasks = tasks;
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
