package DAO;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.*;
public class AccountDAO {
public Account login(String username , String pass) {
	String sql = "SELECT * FROM ACCOUNT Where username = ? AND password= ? ";
	try {
		Connection con = DBConnect.getConnect();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return new Account(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getInt("number"),rs.getString("address"), rs.getBoolean("false"));
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
}
public void register(Account acc) {
	String sql ="INSERT INTO ACCOUNT VALUES (?,?,?,?,?,?)";
	try (Connection c = DBConnect.getConnect();
			PreparedStatement ps = c.prepareStatement(sql)){
		ps.setString(1,acc.getUserName());
		ps.setString(2,acc.getEmail());
		ps.setString(3,acc.getPassword());
		ps.setInt(4,acc.getIdAccount());
		ps.setInt(5,acc.getNumber());
		ps.executeUpdate();
			
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
