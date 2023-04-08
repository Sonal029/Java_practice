package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.dto.Department;
import com.masai.dto.Employee;
import com.masai.exception.SomethingWentWrongException;

public class DepartmentDAOImpl implements DepartmentDAO{

	@Override
	public void addDepartment(Department dept) throws SomethingWentWrongException {
		Connection conn =  null;
			
			try
			{
				conn = DBUtils.getConnectionTodatabase();
				
				String query = "Insert into department values(?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, dept.getD_id());
				ps.setString(2, dept.getD_name());
				ps.setString(3, dept.getD_location());
				
				
				ps.executeUpdate();
			}
			
			catch (ClassNotFoundException | SQLException e) {
				throw new SomethingWentWrongException("There is an error");
			}
			finally
			{
				try {
					DBUtils.closeConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	     }	
		
		
	}

}

