package br.edu.ifsp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MariaDatabase implements Database {

	private String username;
	
	private String password;

	private String databaseName;
	
	private String host;
	
	private int port;
	
	private Connection connection;
	
	public MariaDatabase(String username, String password, String databaseName, String host, int port) {
		this.username = username;
		this.password = password;
		this.databaseName = databaseName;
		this.host = host;
		this.port = port;
	}
	
	public MariaDatabase(String username, String password, String databaseName, String host) {
		this(username, password, databaseName, host, 3306);
	}
	
	public MariaDatabase(String username, String password, String databaseName) {
		this(username, password, databaseName, "localhost", 3306);
	}
	
        @Override
	public boolean connect() {
		
		boolean result = true;
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			
			if (connection != null)
				connection.close();
			
			this.connection = 
				DriverManager.getConnection(
					"jdbc:mariadb://" + this.host + ":" + port + "/" + this.databaseName,
					this.username, this.password);
			
		} catch (ClassNotFoundException | SQLException e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}
	
        @Override
	public ResultSet query(String sql) {
		
		ResultSet result = null;
		
		try {
			
			if (connection != null && !connection.isClosed()) {
				
				
				PreparedStatement statement = this.connection.prepareStatement(sql);
				
				result = statement.executeQuery();
			
			} else 			
				throw new Exception("Database is not connected.");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
        @Override
	public boolean disconnect() {
		
		boolean result = false;
		
		try {
		
			if (this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				result = true;
			}
		
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
	}

	@Override
	public boolean insert(String sql) {
            
            int result = 0;
            
            try {
                    
                PreparedStatement ps = connection.prepareStatement(sql);
                result = ps.executeUpdate();
                   
            } catch (Exception e) {
                e.printStackTrace();
            } 
                
            return result > 0;
	}

	@Override
	public boolean update(String sql) {
                        
            int result = 0;
            
            try {
                    
                PreparedStatement ps = connection.prepareStatement(sql);
                result = ps.executeUpdate();
                   
            } catch (Exception e) {
                e.printStackTrace();
            } 
                
            return result > 0;
	}

	@Override
	public boolean delete(String sql) {
            
            int result = 0;
            
            try {
                    
                PreparedStatement ps = connection.prepareStatement(sql);
                result = ps.executeUpdate();
                   
            } catch (Exception e) {
                e.printStackTrace();
            } 
                
            return result > 0;
	}
}
