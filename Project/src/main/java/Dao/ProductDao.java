package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connectionl.DBConnection;
import Model.Product;

public class ProductDao {
	public static void insertProduct(Product p){
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into product(sid,image,pname,pprice,pcategory) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, p.getSid());
			pst.setString(2, p.getImage());
			pst.setString(3, p.getPname());
			pst.setDouble(4, p.getPprice());
			pst.setString(5, p.getPcategory());
			pst.executeUpdate();
			System.out.println("product stored");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Product> getProductsBySid(int id){
		List<Product> list  = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql= "select * from product where sid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pname"));
				p.setPprice(rs.getDouble("pprice"));
				p.setPcategory(rs.getString("pcategory"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}