package com.ques2;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo d1 = ctx.getBean("demo",Demo.class);
		d1.showDetails();
	}
	
	private Map<Department, Employee> theMap;
	//use setter injection to inject theMap;
	

	public Map<Department, Employee> getTheMap() {
		return theMap;
	}

	public void setTheMap(Map<Department, Employee> theMap) {
		this.theMap = theMap;
	}

	
	public void myInit(){
		System.out.println("inside myInit method");
	}

	public void cleanUp(){
		System.out.println("inside cleanUp method");
	}

	public void showDetails(){
		System.out.println("inside showDetails of Demo class");
		for (Map.Entry<Department, Employee> entry : theMap.entrySet()) {
	        Department department = entry.getKey();
	        Employee employee = entry.getValue();
	        System.out.println(department.toString());
	        System.out.println(employee.toString());
	    }
		
	}
}
