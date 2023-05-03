package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Employee;
import com.masai.Service.EmployeeService;


@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployeeHandler()
	{
		List<Employee> empList = empService.getEmployeeList();
		
		return new ResponseEntity<>(empList , HttpStatus.OK);
	}
	
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployeeHandler(@RequestBody Employee emp)
	{
		
	}
}
