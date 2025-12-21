package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Restaurant;

public class RestaurantDAO {
public Restaurant getRestaurant(int id , String name, String address , String email, String number ,String decription , int rating ) {
	String sql = "SELECT * FROM RESTAURENT WHERE RESID = ? AND RNAME = ? AND ADDRES = ? AND EMAIL = ? AND PHONE = ? AND RATING = ? AND DECRIPTION = ? ";
	try {
		Connection con = DBConnect.getConnect() ;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setString(4, email);
		ps.setString(5, number);
		ps.setString(6,decription);
		ps.setLong(7, rating);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return new Restaurant(rs.getInt(id), rs.getString(name), rs.getString(address), rs.getString(email), rs.getString(number), rs.getString(decription), rs.getInt( rating));
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
}
}
