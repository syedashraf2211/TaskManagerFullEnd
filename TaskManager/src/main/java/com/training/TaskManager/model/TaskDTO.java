package com.training.TaskManager.model;

import java.util.Date;

public class TaskDTO {

	private int TaskId;
	private String TaskName;
	private String Description;
	private int Progress;
	private Date EndDate;
	
	private EmployeeInfo empinf;
	private ManagerInfo mnginf;
	
	
	
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
	public EmployeeInfo getEmpinf() {
		return empinf;
	}
	public void setEmpinf(EmployeeInfo empinf) {
		this.empinf = empinf;
	}
	public ManagerInfo getMnginf() {
		return mnginf;
	}
	public void setMnginf(ManagerInfo mnginf) {
		this.mnginf = mnginf;
	}
	
	public TaskInfo toEntity(TaskDTO taskinfo)
	{
		return new TaskInfo(taskinfo.getTaskId(),taskinfo.getTaskName(),taskinfo.getDescription(),taskinfo.getProgress(),
				taskinfo.getEndDate(),taskinfo.getEmpinf(),taskinfo.getMnginf());	
	}
}
