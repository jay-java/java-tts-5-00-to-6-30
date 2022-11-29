package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Connectionl.DBConnection;
import Model.Cart;

public class CartDao {
	public static void insertIntoCart(Cart c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into cart(cusid,pid) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getCusid());
			pst.setInt(2, c.getPid());
			pst.executeUpdate();
			System.out.println("inserted into cart");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
