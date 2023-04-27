package com.masai.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/welcome")
	@ResponseBody
	public String getWelcomenote()
	{
		String str ="Welcome to spring boot first example"; 
		return str;
		
	}
	
	@RequestMapping("/students")
	@ResponseBody
	public Student StudentList()
	{
		Student std= new Student(5, "Sonal", 523);
		return std;
	}
	
	@RequestMapping("/studentList")
	@ResponseBody
	public List<Student> getStudentList()
	{
		List<Student> std = new ArrayList<>();
		Student std1= new Student(1, "Sonal", 523);
		Student std2= new Student(2, "Monal", 528);
		Student std3= new Student(3, "Tonal", 527);
		Student std4= new Student(4, "Donal", 526);
		Student std5= new Student(5, "Vonal", 525);
		Student std6= new Student(6, "Ronal", 524);
		
		
		std.add(std6);
		std.add(std5);
		std.add(std4);
		std.add(std3);
		std.add(std2);
		std.add(std1);
		
		return std;
	}
	
}
