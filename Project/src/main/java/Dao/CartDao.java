package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public static List<Cart> getCartListByCusId(int id){
		List<Cart> list = new ArrayList<Cart>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from cart where cusid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Cart c = new Cart();
				c.setCid(rs.getInt("cid"));
				c.setCusid(rs.getInt("cusid"));
				c.setPid(rs.getInt("pid"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
