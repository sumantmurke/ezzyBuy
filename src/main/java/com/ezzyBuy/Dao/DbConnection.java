package com.ezzyBuy.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ezzyBuy.Domain.User;



public class DbConnection {

	private static String connectionString = "jdbc:mysql://ezzybuy.cnnmp1jopl3g.us-west-1.rds.amazonaws.com:3306/ezzyBuy";
	private static String dbUsername = "root";
	private static String dbPassword = "password";

	
	public boolean loginCheck(String username, String password){
	    String query;
	    boolean login = false;

	    try {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection con = DriverManager.getConnection(connectionString, dbUsername, dbPassword);
	        Statement stmt = (Statement) con.createStatement();
	        query = "SELECT username, password FROM user_details WHERE username='" + username + "' AND password='" + password + "';";
	        System.out.println("username"+username+"pwd"+password);
	        stmt.executeQuery(query);
	        ResultSet rs = stmt.getResultSet();
	        login = rs.first(); //rs.first();
	        con.close();
	    } catch (InstantiationException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return login;
	}
	
	
	
	
	
	
	
	
	
	
	
	public User getUserDetails (String uname){
		
		String query;
		//String bname = "nouser";
		//List<String> nl = new ArrayList<String>();
		String first_name, last_name,username, password, credit_card;
		User userD = new User();
	    try {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection con = DriverManager.getConnection(connectionString, dbUsername, dbPassword);
	        Statement stmt = (Statement) con.createStatement();
	        //String uname = user.getUserName();
	        query = "SELECT * FROM user_details WHERE username ='"+uname+"';";
	        //query = "INSERT into user_details (first_name, last_name, username, password,bucketname) values ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getUserName()+"','"+user.getPassword()+"','"+user.getBucketname()+"')";
	        ResultSet rs = stmt.executeQuery(query);
	        //System.out.println("Bucketname for User "+user.getUserName()+" is "+);
	        /*if(rs.next()){
	        	bname = rs.getString("bucketname");
	        	//bname = (String) rs.getObject(1);
	        	
	        }else
	        	System.out.println("No user found for username = "+username+"  ");
	        System.out.println("Inside DbConnection - testing bucket name: " +bname);*/
	        //int numColumns = rs.getMetaData().getColumnCount();
	        
	        if ( rs.next() ) {
	            
	        	 first_name = rs.getString("first_name");
	        	 last_name = rs.getString("last_name");
	        	 username = rs.getString("username");
	        	 password = rs.getString("password");
	        	 credit_card = rs.getString("credit_card");
	             userD.setFirstName(first_name);
	             userD.setLastName(last_name);
	             userD.setUserName(username);
	             userD.setPassword(password);
	             userD.setCreditCard(credit_card);
	        } else{
	        	return null;
	        }
	        con.close();
	       
	    } catch (InstantiationException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    //return bname;
	    return userD;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
