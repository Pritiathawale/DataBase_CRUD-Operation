package com.cears;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_statement {
      private static String driver="com.mysql.jdbc.Driver";
      private static String url="jdbc:mysql:///db_jdk";
      private static String user="root";
      private static String pwd=null;
      private static String UPDATE_QUERY="update `movies` set Hero='ram' where MovieName='pushpa'";
      
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection con=null;
         Statement st=null;
		try {	
			Class.forName(driver);
			 con=DriverManager.getConnection(url,user,pwd);
             st=con.createStatement();
             int recordCount=st.executeUpdate(UPDATE_QUERY);
                    System.out.println(recordCount+"Record Updated");
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
