package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import Connection.DBConnection;
import model.CustomerUser;
import model.User;

public class Userdao {

	public static void insertuser(User u)
	{
			
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "insert into sellerorcustomer(firstname,lastname,email,contact,password,label) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getFirstname());
			pst.setString(2, u.getLastname());
			pst.setString(3, u.getEmail());
			pst.setLong(4, u.getContact());
			pst.setString(5, u.getPassword());
			
			pst.executeUpdate();
			System.out.print("data inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static User checkLogin(User u) {
		User u1 =null;
		try {
			Connection conn = DBConnection.createconnection();
			String sql="select * from sellerorcustomer where email=? and password=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				u1  =new User();
				u1.setId(rs.getInt("id"));
				u1.setFirstname(rs.getString("firstname"));
				u1.setLastname(rs.getString("lastname"));
				u1.setEmail(rs.getString("email"));
				u1.setContact(rs.getLong("contact"));
				u1.setPassword(rs.getString("password"));
				System.out.print("data checked");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u1;
	}
	public static void update(User u1)
	{
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "update sellerorcustomer set firstname = ?, lastname = ?, email = ?, contact = ?  where id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u1.getFirstname());
			pst.setString(2, u1.getLastname());
			pst.setString(3, u1.getEmail());
			pst.setLong(4, u1.getContact());
			
			pst.setInt(5, u1.getId());
			pst.executeUpdate();
			System.out.print("data updated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static boolean checkpassword(int id, String op)
	{
		boolean flag = false;
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from sellerorcustomer where id = ? and password = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, op);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				flag = true ;
				System.out.println(flag);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public static void changepassword(int id, String np)
	{
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "update sellerorcustomer set password = ? where id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
//			System.out.print("password changed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static boolean checkemail(String email)
	{
		boolean flag = false;
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "select * from sellerorcustomer where email = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
			   flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	public static void forgotpassword(String email, String np)
	{
          try {
			Connection conn = DBConnection.createconnection();
			String sql = "update sellerorcustomer set password=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("password updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
		
	}
}
