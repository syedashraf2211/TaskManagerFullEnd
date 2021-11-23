package com.training.TaskManager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;


@Entity
public class TaskInfo implements Serializable{

	@Id
	@GeneratedValue
	private int TaskId;
	private String TaskName;
	private String Description;
	private int Progress;
	private Date EndDate;
	
	@ManyToOne
	@JoinColumn(name="emp_id")
	private EmployeeInfo empinf;
	
	@ManyToOne
	@JoinColumn(name="mng_id")
	private ManagerInfo mnginf;
	
	public EmployeeInfo getEmpinf() {
		return empinf;
	}
	
	public void setEmpinf(EmployeeInfo empinf) {
		this.empinf = empinf;
	}

	public TaskInfo(int tid,String taskName, String description, int progress,  Date endDate,
			EmployeeInfo empinf, ManagerInfo mnginf) {
		super();
		TaskId = tid;
		TaskName = taskName;
		Description = description;
		Progress = progress;
		EndDate = endDate;
		this.empinf = empinf;
		this.mnginf = mnginf;
	}
	public TaskInfo() {
		super();
	}
	
	public ManagerInfo getMnginf() {
		return mnginf;
	}
	public void setMnginf(ManagerInfo mnginf) {
		this.mnginf = mnginf;
	}
	public int getTaskId() {
		return TaskId;
	}
	public void setTaskId(int taskId) {
		TaskId = taskId;
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getProgress() {
		return Progress;
	}
	public void setProgress(int progress) {
		Progress = progress;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
}
