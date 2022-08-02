package com.cears;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class CRUD_Operation {
	 private static String driver="com.mysql.jdbc.Driver";
     private static String url="jdbc:mysql:///db_jdk";
     private static String user="root";
     private static String pwd=null;
     private static String CREATE_QUERY="CREATE TABLE `db_jdk`.`cinema` (`Index` INT(10) NOT NULL , `movie` VARCHAR(20) NOT NULL,`Actor` VARCHAR(20) NOT NULL,`Actress` VARCHAR(20) NOT NULL)";
     private static String INSERT_QUERY="";
     private static String UPDATE_QUERY="";
     private static String DELETE_QUERY="";
     private static String SELECT_QUERY="select * from cinema";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Connection con=null;
          Statement st=null;
          PreparedStatement ps=null;
          ResultSet rs=null;
          Scanner sc=new Scanner(System.in);
          
          try {
            	Class.forName(driver);
            	con=DriverManager.getConnection(url,user,pwd);
            	st=con.createStatement();
            	rs=null;
            	ps=null;
                int option=0;
                int rows=0;
                int no=0;
                String mName="",Actor="",Actress="";
                System.out.println("!!!!!!!!!!!!!!!!!!Welcome to Database Management!!!!!!!!!!!!!!");
        do {
        	 System.out.println("\n ****************Choose Operation Perform*******************");
        	 System.out.println("---------------------------------------------------------------");
          System.out.println("1.Create Table Query");
          System.out.println("2.Insert Into Table Query");
          System.out.println("3.Update Table Query");
          System.out.println("4.Delete From Table Query");
          System.out.println("5.Select Table Query");
          System.out.println("6.Exit");
          System.out.println("Enter your choise");
          option=sc.nextInt();
          switch(option) {
          case 1: try {
          	st.executeUpdate(CREATE_QUERY);
          	System.out.println("Table Created Successfully");
          } 
         catch(SQLException e) {
          	System.out.println("Table Already Exists");
          }
          	break;
          case 2:
        	  System.out.println("----Insert Record :------");
        	  System.out.println("- Enter Index No :");
        	  no=sc.nextInt();
        	  System.out.println("- Enter Movie Name :");
        	  mName=sc.next();
        	  System.out.println("- Enter actor Name :");
        	  Actor=sc.next();
        	  System.out.println("- Enter actress Name :");
        	  Actress=sc.next();
          	 INSERT_QUERY="insert into `cinema`('index','movie','Actor','Actress') values(?,?,?,?)";
          	 ps=(PreparedStatement)
          			 con.prepareStatement(INSERT_QUERY);
          	 ps.setInt(1, no);
          	 ps.setString(2, mName);
          	 ps.setString(3, Actor);
          	 ps.setString(4, Actress);
          	 rows=ps.executeUpdate();
          	System.out.println(rows+"Record Inserted Successfully");
          	break;
          	
          case 3:
        	  System.out.println("----Update Records :------");
        	  System.out.println("- Enter Index No of the record to be updated :");
        	  no=sc.nextInt();
        	  System.out.println("- Enter Movie Name :");
        	  mName=sc.next();
        	  System.out.println("- Enter actor Name :");
        	  Actor=sc.next();
        	  System.out.println("- Enter actress Name :");
        	  Actress=sc.next();
          	 UPDATE_QUERY="update `cinema` set 'movie'=?,'Actor'=?,Actress'=? where 'index'=?";
          	 ps=(PreparedStatement)
          			 con.prepareStatement(UPDATE_QUERY);
          	 ps.setString(1, mName);
          	 ps.setString(2, Actor);
          	 ps.setString(3, Actress);
          	ps.setInt(4, no);
          	 rows=ps.executeUpdate(); 
        	  
          	
          	System.out.println(rows+ " Record Updated Successfully");
         
          	break;
          
          case 4:
        	  System.out.println("----Delete Records :------");
        	  System.out.println("- Enter Index No of the movie record to be deleted :");
        	  no=sc.nextInt();
      
          	 DELETE_QUERY="delete from `cinema` where 'index' =?";
          	 ps=(PreparedStatement)
          			 con.prepareStatement(DELETE_QUERY);
          	 ps.setInt(1, no);
          	
          	 rows=ps.executeUpdate(); 
        	  
          	
          	System.out.println(rows+ " Record deleted Successfully");
          
          	break;	
          	
          case 5:
             System.out.println("****************Movies Record*****************");
             System.out.println("----------------------------------------------");
             rs=st.executeQuery(SELECT_QUERY);
             while(rs.next()) {
            	 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
             }
          case 6:
        	  System.out.println("!!!!!!!!!!Thank You!!!!!!!!!");
          	break;
          default:
          	System.out.println("Invalid Choise");
             
          }   
	}while(option!=6);
          }
        catch(ClassNotFoundException e) {
        	e.printStackTrace();
        } catch(SQLException e) {
        	e.printStackTrace();
        } 
        finally {
       // 	try {
        //		rs.close();
       // 	} catch(SQLException e) {
        //    	e.printStackTrace();
       // }
        	try {
        		ps.close();
        	} catch(SQLException e) {
            	e.printStackTrace();
        }
        	try {
        		st.close();
        	} catch(SQLException e) {
            	e.printStackTrace();
        	
        }try {
    		con.close();
    	} catch(SQLException e) {
        	e.printStackTrace();
    	
    }
        sc.close();
	}
          
	}
}	


