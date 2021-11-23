package com.training.TaskManager.model;

public class EmployeeDTO 
{
	private int eid;
	private String ename;
	private String email;
	private String password;
	private String designation;
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
	
	public EmployeeInfo toEntity(EmployeeDTO emp)
	{
		return new EmployeeInfo(emp.getEname(),emp.getEmail(),emp.getPassword(),emp.getDesignation());
	}
}
