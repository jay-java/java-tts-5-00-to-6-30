package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connection.DBConnection;
import model.product;

public class productdao {
	public static void insertproduct(product p)
	{
		try {
			Connection conn = DBConnection.createconnection();
			String sql = "insert into product(sid,image,pn,pp,pc) values(?,?,?,?,?)";
			PreparedStatement  pst = conn.prepareStatement(sql);
			pst.setInt(1, p.getSid());
			pst.setString(2, p.getImage());
			pst.setString(3, p.getPn());
			pst.setDouble(4, p.getPp());
			pst.setString(5, p.getPc());
			pst.executeUpdate();
			System.out.print("product data update");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
