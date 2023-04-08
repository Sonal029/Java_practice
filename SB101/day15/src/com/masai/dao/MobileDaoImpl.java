package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Mobile;
import com.masai.dto.MobileImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class MobileDaoImpl implements MobileDao
{

	@Override
	public void addMobile(Mobile mob) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		Connection conn =null;
		
			 try {
					 conn = DBUtils.getConnectionTodatabase();
					 String query = "Insert into mobile(model_no, company,price,MFGDate) values(?,?,?,?)";
					 PreparedStatement ps =conn.prepareStatement(query);
					 ps.setString(1, mob.getModel());
					 ps.setString(2, mob.getCompany());
					 ps.setInt(3, mob.getPrice());
					 ps.setDate(4, Date.valueOf(mob.getMfgDate()));
					 ps.executeUpdate();
			     } 
			 catch (ClassNotFoundException | SQLException e) 
			 {
				 throw new com.masai.exception.SomethingWentWrongException("Unable to insert the record now, try again later");
				}
			 finally {
					try 
					{
						DBUtils.closeConnection(conn);					
					}
					catch(SQLException ex) 
					{
						
					}
				}
		
	}

	@Override
	public void updateMobile(Mobile mob) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		 try {
			 conn = DBUtils.getConnectionTodatabase();
			 String query = "Update mobile set company =?,price=?,MFGDate=? where(model_no = ?)";
			 PreparedStatement ps =conn.prepareStatement(query);
			 
			 ps.setString(1, mob.getCompany());
			 ps.setInt(2, mob.getPrice());
			 ps.setDate(3, Date.valueOf(mob.getMfgDate()));
			 ps.setString(4, mob.getModel());
			 ps.executeUpdate();
	     } 
	 catch (ClassNotFoundException | SQLException e) 
	 {
		 throw new com.masai.exception.SomethingWentWrongException("Unable to insert the record now, try again later");
		}
	 finally {
			try 
			{
				DBUtils.closeConnection(conn);					
			}
			catch(SQLException ex) 
			{
				
			}
		}
		
	}

	@Override
	public void DeleteMobile(String model) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		Connection conn = null;
		 try {
			 conn = DBUtils.getConnectionTodatabase();
			 String query = "Update from mobile where(model_no = ?)";
			 PreparedStatement ps =conn.prepareStatement(query);
			 
			 ps.setString(1, model);
			 ps.executeUpdate();
	     } 
	 catch (ClassNotFoundException | SQLException e) 
	 {
		 throw new com.masai.exception.NoRecordFoundException("Didnt find the data");
		}
	 finally {
			try 
			{
				DBUtils.closeConnection(conn);					
			}
			catch(SQLException ex) 
			{
				
			}
		}
	}

	@Override
	public List<Mobile> SearchByModel(String model) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		List<Mobile> list = new ArrayList<>();
		Connection conn = null;
		 try {
			 conn = DBUtils.getConnectionTodatabase();
		      String query = "Select m.model_no,m.company,m.price, m.MFGdate from mobile m where model_no =?";
		
			  PreparedStatement ps = conn.prepareStatement(query);
			  ps.setString(1, model);
			  ResultSet rs = ps.executeQuery();
				if(DBUtils.isResultSetEmpty(rs)) {
					throw new NoRecordFoundException("No mobile found");
				}
				while(rs.next()) {
					list.add(new MobileImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4).toLocalDate()));
				}
				
			}catch(ClassNotFoundException | SQLException ex) {
				throw new SomethingWentWrongException("Unable to update the record now, try again later");
			}finally {
				try {
					DBUtils.closeConnection(conn);					
				}catch(SQLException ex) {
					
				}
			}
			return list;
		}

	@Override
	public List<Mobile> SearchByPrice(int lower_price, int higher_price) throws NoRecordFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		List<Mobile> list = new ArrayList<>();
		Connection conn = null;
		 try {
			 conn = DBUtils.getConnectionTodatabase();
		      String query = "Select m.model_no,m.company,m.price, m.MFGdate from mobile m where price between ? and ?";
		
			  PreparedStatement ps = conn.prepareStatement(query);
			  ps.setInt(1, lower_price);
			  ps.setInt(2, higher_price);
			  ResultSet rs = ps.executeQuery();
				if(DBUtils.isResultSetEmpty(rs)) {
					throw new NoRecordFoundException("No employee found");
				}
				while(rs.next()) {
					list.add(new MobileImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4).toLocalDate()));
				}
				
			}catch(ClassNotFoundException | SQLException ex) {
				throw new SomethingWentWrongException("Unable to update the record now, try again later");
			}finally {
				try {
					DBUtils.closeConnection(conn);					
				}catch(SQLException ex) {
					
				}
			}
			return list;
	}
	}

