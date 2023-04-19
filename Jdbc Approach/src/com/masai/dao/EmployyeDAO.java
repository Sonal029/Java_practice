package com.masai.dao;

import java.util.List;

import com.masai.dto.Employee;
import com.masai.exception.SomethingWentWrongException;

public interface EmployyeDAO {
	public void addEmployee(Employee emp)throws SomethingWentWrongException;
	public List<Employee> getEmployeeFromAccount() throws SomethingWentWrongException;

}
