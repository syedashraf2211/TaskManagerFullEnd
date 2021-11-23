package com.training.TaskManager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity

public class ManagerInfo implements Serializable
{
	@Id
	@GeneratedValue
	private int mid;
	private String mname;
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "mnginf")
	private List<TaskInfo> tasks = new ArrayList<>();
	
	public List<TaskInfo> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskInfo> tasks) {
		this.tasks = tasks;
	}
	
	public int getMid() {
		return mid;
	}
	public ManagerInfo() {
		super();
	}
	
	
	public ManagerInfo(String mname, String email, String password) {
		super();
		this.mname = mname;
		this.email = email;
		this.password = password;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
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
}
