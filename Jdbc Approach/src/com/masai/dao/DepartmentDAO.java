package com.masai.dao;

import com.masai.dto.Department;
import com.masai.exception.SomethingWentWrongException;

public interface DepartmentDAO 
{
   public void addDepartment(Department dept) throws SomethingWentWrongException;
}
