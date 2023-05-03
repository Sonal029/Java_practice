package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.EmployeeException;
import com.masai.Model.Employee;
import com.masai.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee addEmployee ( Employee emp) 
	{
		Employee addedEmp = empRepo.save(emp);
		
		return addedEmp;
	}
	
	
	public List<Employee> getEmployeeList() throws EmployeeException
	{
		List<Employee> empList = empRepo.findAll();
		if(empList.isEmpty())
		{
			throw new EmployeeException("No Employee Found");
		}
		return empList;
	}
	
	
}
