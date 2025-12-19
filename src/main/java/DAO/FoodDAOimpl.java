package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Food;

public class FoodDAOimpl implements FoodDAO {
	public Food infomation (String fname , int id , int price,String decription) { 
	String sql ="SELECT * FROM FOOD WHERE ID = ? AND FNAME = ? AND PRICE= ? AND DESCRIPTIONS = ?";
	try {
		Connection con = DBConnect.getConnect();
		PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ps.setString(2, fname);
		ps.setLong(3,price);
		ps.setString(4, decription);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return new Food(rs.getInt("id"), rs.getString("fname"),rs.getInt("price"), rs.getString(decription)); 
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return null;
	}
	@Override
	public void insert(Food food) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Food food) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Food food) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Food> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> findALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
