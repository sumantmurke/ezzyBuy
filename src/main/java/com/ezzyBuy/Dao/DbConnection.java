package com.ezzyBuy.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.ezzyBuy.Domain.User;



public class DbConnection {

	private static String connectionString = "jdbc:mysql://ezzybuy.cnnmp1jopl3g.us-west-1.rds.amazonaws.com:3306/ezzyBuy";
	private static String dbUsername = "";
	private static String dbPassword = "";

	public void insertUser(User user){
	    final String query= "INSERT into user_details(first_name, last_name, username, password, credit_card)values(?,?,?,?,?) ";
	//  String query;
		Connection con=null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	         con = DriverManager.getConnection(connectionString, dbUsername, dbPassword);
	     /*   Statement stmt = (Statement) con.createStatement();
	        query = "INSERT into user_details (first_name, last_name, username, password, credit_card) values ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getUserName()+"','"+user.getPassword()+"',"+user.getCreditCard()+"')";
	        stmt.executeUpdate(query);
	       */ 
	       
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, user.getFirstName());
	        pstmt.setString(2, user.getLastName());
	        pstmt.setString(3, user.getUserName());
	        pstmt.setString(4, user.getPassword());
	        pstmt.setString(5, user.getCreditCard());
	        
	        pstmt.executeUpdate();
	      
	        System.out.println("User Inserted successfully");
	        con.close();
	    } catch (InstantiationException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally
	    {
	    	if(con!=null)
	    	{
	    		try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }
	    
	}
}
