package com.masai.ques3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	
	public static void main(String[] args) {
		
		
//		Activating the container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
//	pulling the object  from bean container using id
		Runner r = ctx.getBean(Runner.class , "run");
		r.getD().draw();	
	
	}
}
