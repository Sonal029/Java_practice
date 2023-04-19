package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.DepartmentDAO;
import com.masai.dao.DepartmentDAOImpl;
import com.masai.dto.Department;
import com.masai.dto.DepartmentImpl;
import com.masai.exception.SomethingWentWrongException;

public class UIDepartment {

		public static void addDepartment(Scanner sc)
		{
			System.out.println("Enter department id");
			String d_id = sc.next();
			System.out.println("Enter department name");
			String d_name = sc.next();
			System.out.println("Enter department location");
			String d_location =sc.next();
			
			Department dept = new DepartmentImpl(d_id,d_name,d_location);
		
			DepartmentDAO deptDao = new DepartmentDAOImpl();
			try
			{
				deptDao.addDepartment(dept);
				System.out.println("Department added sucessfully");
			}
			catch(SomethingWentWrongException ex)
			{
				System.out.println(ex);
			}
		}
	}
