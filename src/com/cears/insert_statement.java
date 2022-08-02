package com.cears;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert_statement {
       private static String INSERT_QUERY="INSERT INTO `movies` (`Tno`, `MovieName`, `Hero`, `Heroine`) VALUES ('202', 'Bhramastra', 'Ranbir', 'Aalia')";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection con=null;
         Statement st=null;
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql:///db_jdk","root",null);
             st=con.createStatement();
             int recordCount=st.executeUpdate(INSERT_QUERY);
            		 System.out.println(recordCount+" record inserted");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch(Exception e) {
		e.printStackTrace();
	}
		finally {
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
