package ques1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class productCRUDOperations 
{
  

	 static Connection getConnectiontoDatabase() throws SQLException, ClassNotFoundException
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		  return DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
	  }
 
 
	 static void closeConnection(Connection conn) throws SQLException
	 {
		 if(conn!=null)
		 {
			 conn.close();
		 }
	 }
 
 
 
    	static void addProduct(Scanner sc) throws SQLException
		 {
			 Connection conn = null;
			 try
			 {
				 conn = getConnectiontoDatabase();
				 
				 String query = ("INSERT INTO Product(pid,pname,quantity,price) values(?,?,?,?)");
				 
				 PreparedStatement ps =conn.prepareStatement(query);
				 System.out.println("Enter product id");
				 int pid =sc.nextInt();
				 ps.setInt(1, pid);
				 
				 
				 System.out.println("Enter product name");
				 String pname =sc.next();
				 ps.setString(2, pname);
				 
				 
				 System.out.println("Enter product quantity");
				 int quantity =sc.nextInt();
				 ps.setInt(3, quantity);
				 
				 
				 System.out.println("Enter product price");
				 int price =sc.nextInt();
				 ps.setInt(4, price);
				 
				 if(ps.executeUpdate()>0)
				 {
					 System.out.println("Product added sucessfully");
				 }
				 else
				 {
					 System.out.println("Couldn't add the product");
				 }
			 }
				 catch(ClassNotFoundException | SQLException ex)
				 {
					 
				 }
				 finally
				 {
					if(conn!=null) 
					{
						conn.close();
				     }
			 }
		 }


		static void updateProduct(Scanner sc) throws SQLException
		{
			Connection conn = null;
			try
			{
				conn = getConnectiontoDatabase();
				
				String query = "UPDATE product SET price = ?, quantity =? WHERE pid=?";
				PreparedStatement ps = conn.prepareStatement(query);
				
				System.out.println("Enter price of the product");
				int price = sc.nextInt();
				ps.setInt(1, price);
				
				
				System.out.println("Enter quantity of the product");
				int quantity = sc.nextInt();
				ps.setInt(2,quantity);
				
				System.out.println("Enter pid of the product where changes is to be made");
				int pid = sc.nextInt();
				ps.setInt(3,pid);
				
				 if(ps.executeUpdate()>0)
				 {
					 System.out.println("Product updated sucessfully");
				 }
				 else
				 {
					 System.out.println("Couldn't update the product");
				 }
				
			}
			catch(ClassNotFoundException | SQLException ex)
			{
				
			}
			finally
			{
				if(conn!=null)
				{
					conn.close();
				}
			}
		}
		
		
		
		static void deleteProduct() throws SQLException
		{
			
			Connection conn = null;
			try
			{
				conn = getConnectiontoDatabase();
				String query = "DELETE FROM product WHERE quantity<2";
				PreparedStatement ps = conn.prepareStatement(query);
				
				if(ps.executeUpdate()>0)
				{
					System.out.println("Deletion Sucessful");
				}
				else
				{
					System.out.println("Couldn't delete");
				}
			}
			catch(ClassNotFoundException | SQLException ex)
			{
				
			}
			finally
			{
				if(conn!=null)
				{
					conn.close();
				}
			}
			
			
		}
		static void deleteProductByProductid(Scanner sc) throws SQLException
		{
			
			Connection conn = null;
			try
			{
				conn = getConnectiontoDatabase();
				String query = "DELETE FROM product WHERE pid = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				
				System.out.println("Enter pid");
				int pid = sc.nextInt();
				
				ps.setInt(1, pid);
				if(ps.executeUpdate()>0)
				{
					System.out.println("Deletion Sucessful");
				}
				else
				{
					System.out.println("Couldn't delete");
				}
			}
			catch(ClassNotFoundException | SQLException ex)
			{
				
			}
			finally
			{
				if(conn!=null)
				{
					conn.close();
				}
			}
			
			
		}
		
		
		static void displayProduct() throws SQLException
		{
			Connection conn=null;
			try
			{
				conn = getConnectiontoDatabase();
				
				String query = "SELECT * FROM product";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ResultSet rs = ps.executeQuery();
//				System.out.println(rs);
				
				if(!rs.isBeforeFirst() && rs.getRow()==0)
				{
					System.out.println("No employee found");
				}
				
				else
				{
					while(rs.next())
					{
						System.out.println("Product id: "+rs.getInt(1));
						System.out.println("Product Name: "+rs.getString(2));
						System.out.println("Quantity: "+rs.getInt(3));
						System.out.println("Price: " +rs.getInt(4));
						
					}
				}
			}
			catch(ClassNotFoundException | SQLException ex)
			{
				
			}
			
			finally
			{
				if(conn!=null)
				{
						closeConnection(conn);
				}
			}
					
		}
		
		
		
		static void searchProductByName(Scanner sc) throws SQLException
		{
			
			Connection conn=null;
			try
			{
				conn = getConnectiontoDatabase();
				
				String query = "SELECT * FROM product WHERE pname = ?";
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				System.out.println("Enter the name of the product to be searched");
				
				String name = sc.next();
				
				ps.setString(1, name);
				
				ResultSet rs = ps.executeQuery();
				
				if(!rs.isBeforeFirst() && rs.getRow()==0)
				{
					System.out.println("No employee found");
				}
				
				else
				{
					while(rs.next())
					{
						System.out.println("Product id"+rs.getInt(1));
						System.out.println("Product Name"+rs.getString(2));
						System.out.println("Price"+rs.getInt(3));
						System.out.println("Quantity"+rs.getInt(4));
					}
				}
			}
			catch(ClassNotFoundException | SQLException ex)
			{
				
			}
			
			finally
			{
				if(conn!=null)
				{
						closeConnection(conn);
				}
			}
		}
		
		static void searchProductByPriceRange(Scanner sc) throws SQLException
		{
			
			Connection conn=null;
			try
			{
				conn = getConnectiontoDatabase();
				
				String query = "SELECT * FROM product WHERE price between ? and ?";
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				System.out.println("Enter the lower price of the product to be searched");
				
				String lower = sc.next();
				
				ps.setString(1, lower);
				
                System.out.println("Enter the lower price of the product to be searched");
				
				String upper = sc.next();
				
				ps.setString(1, upper);
				
				ResultSet rs = ps.executeQuery();
				
				if(!rs.isBeforeFirst() && rs.getRow()==0)
				{
					System.out.println("No employee found");
				}
				
				else
				{
					while(rs.next())
					{
						System.out.println("Product id"+rs.getInt(1));
						System.out.println("Product Name"+rs.getString(2));
						System.out.println("Price"+rs.getInt(3));
						System.out.println("Quantity"+rs.getInt(4));
					}
				}
			}
			catch(ClassNotFoundException | SQLException ex)
			{
				
			}
			
			finally
			{
				if(conn!=null)
				{
						closeConnection(conn);
				}
			}
		}
			
			
			
	  public static void main(String[] args) throws SQLException {
		
		  Scanner sc = new Scanner(System.in);
		  int choice=0;
		  
		  do
		  {
			  System.out.println("from the menu below enter your choice");
			  System.out.println("1. Add Product");
			  System.out.println("2. View Product");
			  System.out.println("3. Delete Product");
			  System.out.println("4. Update Product");
			  System.out.println("5. Search Product by Name");
			  System.out.println("6. Search product by Price Range");
			  System.out.println("7. Delete product by productId");
			  
			  choice = sc.nextInt();
			  
			  switch(choice)
			  {
			    case 1: 
			    	addProduct(sc);
			    	break;
			    case 2: 
			    	displayProduct();
			    	break;
			    case 3: 
			    	addProduct(sc);
			    	break;
			    case 4: 
			    	updateProduct(sc);
			    	break;
			    case 5: 
			    	searchProductByName(sc);
			    	break;
			    case 6: 
			    	searchProductByPriceRange(sc) ;
			    	break;
			    case 7:
			    	deleteProductByProductid(sc);
			    	break;
			    case 0:
			    	System.out.println("Thank you");
			    	break;
			    default:
			    	System.out.println("Invalid choice");
			   }
		  }
		  while(choice!=0);
		  sc.close();
	}
			
			

}
