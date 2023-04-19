package com.masai.ui;

import java.util.Scanner;

import com.masai.dto.Employee;
import com.masai.dto.EmployeeImpl;

public class UIMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice=0;
		
		do {
			System.out.println("Select option from the menu given below");
			System.out.println("0. Exit");
			System.out.println("1. Enter details in department table ");
			System.out.println("2. Enter details in employee table");
			System.out.println("3. To get all the Employee details who work in the “Account” department.");
			System.out.println("4. To delete the Department based on did, by taking the input from the user.");
			System.out.println("5. To get the Department details of those employees who live in Mumbai");
			
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				UIDepartment.addDepartment(sc);
				break;
			case 2:
				UIEmployee.addEmployee(sc);
				break;
			case 3:
//				employeeFromAccountsDepartment();
				break;
			case 4:
//				deleteDepartment();
				break;
			case 5:
//				employeeFromMumbai();
				break;
			case 0:
				System.out.println("thanks for choosing");
	             break;
	        default:
	        	System.out.println("Incorrect choice Try Again");
	            	 
				
			}
		
		}
		
		   while(choice!=0);
		
	}


	
}
