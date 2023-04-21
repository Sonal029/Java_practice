package com.ques2;

public class Employee {

	private int empId;
	private String empName;
	private String address;
	private int salary;
	public Employee(int empId, String empName, String address, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", salary=" + salary
				+ "]";
	}
	
	
	//use constructor injection to inject the above fields.
	//override the toString method with all the above fields
}
