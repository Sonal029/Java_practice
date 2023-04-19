package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Employee;
import com.masai.dto.EmployeeImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class employeeDAOImpl implements EmployyeDAO 
{

	@Override
	public void addEmployee(Employee emp) throws SomethingWentWrongException 
	{
		
		Connection conn =  null;
		
		try
		{
			conn = DBUtils.getConnectionTodatabase();
			
			String query = "Insert into employee values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, emp.getEmpId());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getAddress());
			ps.setLong(4,emp.getMobile());
			ps.setString(5, emp.getDeptid());
			
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
    @Override
	public List<Employee> getEmployeeFromAccount() throws SomethingWentWrongException {
		List<Employee> list = new ArrayList<>();
		Connection conn = null;
		try
		{
			conn = DBUtils.getConnectionTodatabase();
			
			String query = "SELECT * from employee e INNER Join department d On e.deptid = d.did where d.dname='Accounts'";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No product in category ");
			}
			
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new EmployeeImpl(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getLong(4), rs.getString(5)));
			}
		}catch(ClassNotFoundException | SQLException | NoRecordFoundException ex) {
			throw new SomethingWentWrongException("Unable to add category");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}	
	
}

