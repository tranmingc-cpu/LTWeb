package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
private static String DriveClass ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
private static String url ="jdbc:sqlserver://DESKTOP-1AQF1D9:1433;databaseName=FOODOrderBDencrypt=true;trustServerCertificate=true;";

private static String username = "sa";
private static String password ="26122005";
static {
	try {
		Class.forName(DriveClass);
	} catch (ClassNotFoundException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public static Connection getConnect() throws SQLException {
	return DriverManager.getConnection(url,username,password);
}
}
