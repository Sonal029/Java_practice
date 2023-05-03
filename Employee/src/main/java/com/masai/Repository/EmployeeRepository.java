package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
   
	
}
