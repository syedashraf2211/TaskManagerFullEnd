package com.training.TaskManager.aspect;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.springframework.stereotype.Component;

@Aspect  
@Component  
public class ControllerAspect   
{  
	public static final Logger log = Logger.getLogger(ControllerAspect.class);
	@Before(value = "execution(* com.training.TaskManager.EmployeeController.*(..))")  
	public void beforeAdvice(JoinPoint joinPoint) 
	{  
		log.info("Before method:" + joinPoint.getSignature().getName()); 
	}  
}  