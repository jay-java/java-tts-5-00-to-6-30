package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DBConnection;
import model.CustomerUser;

public class customerdao {
	
	public static void insertcustomer(CustomerUser u)
	{
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "insert into customer(firstname,lastname,email,contact,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getFirstname());
			pst.setString(2, u.getLastname());
			pst.setString(3, u.getEmail());
			pst.setLong(4, u.getContact());
			pst.setString(5, u.getPassword());
			pst.executeUpdate();
			System.out.println("data inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static CustomerUser checklogin(CustomerUser u)
	{
		CustomerUser u1 = new CustomerUser();
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from customer where email= ? and password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				u1.setId(rs.getInt("id"));
				u1.setFirstname(rs.getString("firstname"));
				u1.setLastname(rs.getString("lastname"));
				u1.setEmail(rs.getString("email"));
				u1.setContact(rs.getLong("contact"));
				u1.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u1;
	}
   public static void updateCustomer(CustomerUser u)
   {
	   try {
		Connection conn = DBConnection.createconnection();
		String sql = "update customer set firstname= ?, lastname = ? , email = ? , contact = ? where id = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, u.getFirstname());
		pst.setString(2, u.getLastname());
		pst.setString(3, u.getEmail());
		pst.setLong(4, u.getContact());
		pst.setInt(5, u.getId());
		pst.executeUpdate();
		System.out.println("data updated");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
}
