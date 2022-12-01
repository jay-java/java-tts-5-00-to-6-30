package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Connectionl.DBConnection;
import Model.WishList;

public class WishListDao {
	public static void insetWishList(WishList w) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into wishlist(cusid,pid) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, w.getCusid());
			pst.setInt(2, w.getPid());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
