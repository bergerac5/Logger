package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/Student";
    private static final String USER = "postgres";
    private static final String PASSWORD = "kigali45";
    private static final String DRIVER_CLASS = "org.postgresql.Driver";
    
    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load JDBC driver", e);
        }
    }
    
    public static Connection getConnection() throws SQLException{
    	return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
//    public static void main (String [] args) {
//    	try {
//			getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
}
