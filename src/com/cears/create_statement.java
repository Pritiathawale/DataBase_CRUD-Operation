package com.cears;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class create_statement {
     private static String CREATE_QUERY="CREATE TABLE `student`.`student` (`rollno` INT(10) NOT NULL , `name` VARCHAR(20) NOT NULL ) ENGINE = InnoDB;";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Connection con=null;
         Statement st=null;
       try {
    	   Class.forName("com.mysql.jdbc.Driver");
   		 con=DriverManager.getConnection("jdbc:mysql:///student","root",null);
   		if(con!=null) {
   			System.out.println("Connection created succefully");
   		}
   		else {
   			System.out.println("Not Connected");
   		}
   	    st=con.createStatement();
   		st.executeUpdate(CREATE_QUERY);
   		System.out.println("table created successfully");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		// TODO: handle exception
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	   
	}
}
