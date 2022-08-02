package com.cears;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Select_statement {

	public static void main(String[] args) {
		try {	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql:///db_jdbc","root",null);
		if(con!=null) {
			System.out.println("Connection created succefully");
		}
		else {
			System.out.println("Not Connected");
		}
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from employee");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
