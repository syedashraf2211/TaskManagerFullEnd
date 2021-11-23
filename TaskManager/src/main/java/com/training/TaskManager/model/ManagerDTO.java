package com.training.TaskManager.model;

public class ManagerDTO 
{
	private int mid;
	private String mname;
	private String email;
	private String password;
	public int getMid() {
		return mid;
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
	
	public ManagerInfo toEntity(ManagerDTO manager)
	{
		return new ManagerInfo(manager.getMname(), manager.getEmail(), manager.getPassword());
	}
}
