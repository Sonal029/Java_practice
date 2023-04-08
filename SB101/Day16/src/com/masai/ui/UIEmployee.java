package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.EmployyeDAO;
import com.masai.dao.employeeDAOImpl;
import com.masai.dto.Employee;
import com.masai.dto.EmployeeImpl;
import com.masai.exception.SomethingWentWrongException;

public class UIEmployee {

	public static void addEmployee(Scanner sc)
	{
		
		System.out.println("Enter Employee id");
		String empId=sc.next();
		System.out.println("Enter Employee name");
		String ename=sc.next();
		System.out.println("Enter address");
		String address=sc.next();
		System.out.println("Enter mobile");
		long mob = sc.nextLong();
		System.out.println("Enter department id");
		String deptId = sc.next();
		
		Employee emp = new EmployeeImpl(empId, ename, address, mob, deptId);
		
		EmployyeDAO empd =  new employeeDAOImpl();
		try
		{
			empd.addEmployee(emp);
			System.out.println("Employee added sucessfully");
		}
		catch(SomethingWentWrongException ex)
		{
			System.out.println(ex);
		}
		
	}

	public static void getEmployeeFromAccount()
	{
		
	}
	 
}
