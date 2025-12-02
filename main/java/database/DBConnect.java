package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Food;
public class DBConnect {
	public static void  XuatdsFood(ArrayList<Food> foods) { 
		for (Food f : foods) {
				System.out.println(f.getName());
		}		
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String user = "sa";
 String pass = "26122005";
 String url = "jdbc:sqlserver://DESKTOP-1AQF1D9:1433;databaseName=FoodDB;encrypt=true;trustServerCertificate=true;";

	Connection con = null;	
		con =DriverManager.getConnection(url,user,pass);
		System.out.println("thanh cong");
		ArrayList<Food> food = new ArrayList<>();
		String sql = "select* from Food";
		PreparedStatement ps = con.prepareStatement(sql);	
		ResultSet rs  = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getNString(2);
			double price = rs.getDouble(3);
			String image = rs.getNString(4);
			String decsiption = rs.getNString(5);
			foods.add(new Food(id,name,price,image,decsiption));
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	
		System.out.println("that bai");
		}
	return  ;
}
}

