package com.training.TaskManager.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.TaskManager.model.TaskInfo;

@Service
public class TaskService implements TaskServiceInterface
{

	@Autowired
	EmployeeService eservice;
	
	@Override
	public void saveOrUpdate(TaskInfo tinfo, String enddate,String email) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter1.parse(enddate);
		tinfo.setEndDate(date);
		//System.out.println(eservice.findByEmail(email));
	}
	
}
