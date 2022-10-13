package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.User;

public class UserDao {
	public static void insertUser(User u) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into user(name,contact,address,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getName());
			pst.setLong(2, u.getContact());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPassword());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static User checkLogin(User u) {
		User u1 =null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from user where email=? and password=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				u1  =new User();
				u1.setId(rs.getInt("id"));
				u1.setName(rs.getString("name"));
				u1.setContact(rs.getLong("contact"));
				u1.setAddress(rs.getString("address"));
				u1.setEmail(rs.getString("email"));
				u1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u1;
	}
	public static List<User> getAllUser(){
		List<User> list = new ArrayList<User>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from user";
			PreparedStatement pst  = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				User u  =new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setContact(rs.getLong("contact"));
				u.setAddress(rs.getString("address"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static User getUserById(int id) {
		User u = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from user where id=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setContact(rs.getLong("contact"));
				u.setAddress(rs.getString("address"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	public static void updateUser(User u) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="update user set name=?,contact=?,address=?,email=?,password=? where id=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setString(1, u.getName());
			pst.setLong(2, u.getContact());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPassword());
			pst.setInt(6, u.getId());
			pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteUser(int id) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="delete from user where id=?";
			PreparedStatement pst  = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
