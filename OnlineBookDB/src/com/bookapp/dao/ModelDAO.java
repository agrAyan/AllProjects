package com.bookapp.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ModelDAO {
	static Connection connection;

	public static Connection openConnection()  {
		
		Properties properties= new Properties();
		try {
			properties.load(new FileReader("jdbc.properties"));
		} catch (FileNotFoundException e1) {
			System.out.println("jdbc.properties  file not found");
			
		} catch (IOException e1) {
			System.out.println("Io exception");
			e1.printStackTrace();
		}
		//String drivername ="training";
		String url = (String) properties.getProperty("driver");
		String username = (String) properties.getProperty("username");
		String password = (String) properties.getProperty("password");
		connection = null;
		try {
			//Class.forName(drivername);
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
