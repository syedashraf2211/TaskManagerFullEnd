package com.training.TaskManager.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;


@Entity
public class TaskInfo {

	@Id
	private int TaskId;
	private String TaskName;
	private String Description;
	private int Progress;
	private Date StartDate;
	private Date EndDate;
	/*
	@ManyToOne
	private EmployeeInfo empinf;
	
	@ManyToOne
	private ManagerInfo mnginf;
	public EmployeeInfo getEmpinf() {
		return empinf;
	}
	
	public void setEmpinf(EmployeeInfo empinf) {
		this.empinf = empinf;
	}

	public TaskInfo(int taskId, String taskName, String description, int progress, Date startDate, Date endDate,
			EmployeeInfo empinf, ManagerInfo mnginf) {
		super();
		TaskId = taskId;
		TaskName = taskName;
		Description = description;
		Progress = progress;
		StartDate = startDate;
		EndDate = endDate;
		this.empinf = empinf;
		this.mnginf = mnginf;
	}
	public TaskInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerInfo getMnginf() {
		return mnginf;
	}
	public void setMnginf(ManagerInfo mnginf) {
		this.mnginf = mnginf;
	}
	*/
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
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
}
