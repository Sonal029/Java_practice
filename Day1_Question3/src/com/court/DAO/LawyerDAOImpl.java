package com.court.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.court.DTO.Lawyer;
import com.court.DTO.LawyerImpl;
import com.court.Exception.SomethingWentWrongException;

public class LawyerDAOImpl implements LawyerDAO {

	@Override
	public void addLAwyer(Lawyer l) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=DBUtils.getConnectionTodatabase();
			String query = "INSERT INTO LAWYER VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, l.getId());
			ps.setString(2, l.getName());
			ps.setString(3, l.getEmail());
			ps.setString(4, l.getAddress());
			ps.setInt(5, l.getExperience());
			
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			throw new SomethingWentWrongException("there is something wrong");
		}
		finally
		{
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public void updateLAwyer(Lawyer l) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=DBUtils.getConnectionTodatabase();
			String query = "UPDATE LAWYER SET name=?,email=?,address=?,experience=? WHERE  id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, l.getName());
			ps.setString(2, l.getEmail());
			ps.setString(3, l.getAddress());
			ps.setInt(4, l.getExperience());
			ps.setInt(5, l.getId());
			
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			throw new SomethingWentWrongException("there is something wrong");
		}
		finally
		{
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public void deleteLAwyer(int id) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
				conn=DBUtils.getConnectionTodatabase();
				String query = "DELETE FROM LAWYER WHERE id=?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, id);
			    ps.executeUpdate();
			
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				throw new SomethingWentWrongException("there is something wrong");
			}
			finally
			{
				try {
					DBUtils.closeConnection(conn);
				} 
				catch (SQLException e)
				{
					
				}
			}
	}


	
	@Override
	public List<Lawyer> viewLawyer() throws SomethingWentWrongException {
		
		List<Lawyer> list = new ArrayList<>();
		Connection conn = null;
		try {
				conn=DBUtils.getConnectionTodatabase();
				String query = "SELECT * FROM LAWYER ";
				PreparedStatement ps = conn.prepareStatement(query);
			    ResultSet rs =ps.executeQuery();
			    if(DBUtils.isResultSetEmpty(rs))
			    {
			    	System.out.println("Empty data Set");
			    }
			    else
			    {
			    	while(rs.next())
			    	{
			    		list.add(new LawyerImpl(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			    	}
			    }
			
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				throw new SomethingWentWrongException("there is something wrong");
			}
			finally
			{
				try {
					DBUtils.closeConnection(conn);
				} 
				catch (SQLException e)
				{
					
				}
			}
		
		return list;
	}

}
