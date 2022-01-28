package it.beije.pascal.domus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String URL = "jdbc:mysql://localhost:3306/domus?serverTimezone=CET";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Chinetti";
	
	private static ConnectionManager instance;

	private ConnectionManager() {
		
	}
	
	public static ConnectionManager getInstance() {
		if(instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {		
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
	}
}
