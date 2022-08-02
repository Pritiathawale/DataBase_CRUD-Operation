package com.cears;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MenuDriven_statement {
	 private static String driver="com.mysql.jdbc.Driver";
     private static String url="jdbc:mysql:///priti";
     private static String user="root";
     private static String pwd=null;
     private static String CREATE_QUERY="CREATE TABLE `priti`.`staff` (`Id` INT(10) NOT NULL , `name` VARCHAR(20) NOT NULL )";
     private static String INSERT_QUERY="INSERT INTO `staff` (`Id`, `name`) VALUES ('102', 'kiara')";
     private static String UPDATE_QUERY="update `staff` set name='varun' where Id='202'";
     private static String DELETE_QUERY="delete from `staff` where name='xyz'";
     private static String SELECT_QUERY="select * from staff";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            Connection con=null;
            Statement st=null;
            Scanner sc=new Scanner(System.in);
            int choise;
          while(true) {
            System.out.println("1.Create Table Query");
            System.out.println("2.Insert Into Table Query");
            System.out.println("3.Update Table Query");
            System.out.println("4.Delete From Table Query");
            System.out.println("5.Select Table Query");
            System.out.println("6.Exit");
            System.out.println("Enter your choise");
            choise=sc.nextInt();
            switch(choise) {
            case 1: try {
            	Class.forName(driver);
            	con=DriverManager.getConnection(url,user,pwd);
            	st=con.createStatement();
            	st.executeUpdate(CREATE_QUERY);
            	System.out.println("Table Created Successfully");
            } catch(ClassNotFoundException e) {
            	e.printStackTrace();
            } catch(SQLException e) {
                 System.out.println("Table already exists...");
            } catch(Exception e) {
            	e.printStackTrace();
            }
            	break;
            case 2: try {
            	Class.forName(driver);
            	con=DriverManager.getConnection(url,user,pwd);
            	st=con.createStatement();
            	int recordCount=st.executeUpdate(INSERT_QUERY);
            	System.out.println(recordCount+"Record Inserted Successfully");
            } catch(ClassNotFoundException e) {
            	e.printStackTrace();
            } catch(SQLException e) {
            	e.printStackTrace();
            } catch(Exception e) {
            	e.printStackTrace();
            }
            	break;
            	
            case 3:try {
            	Class.forName(driver);
            	con=DriverManager.getConnection(url,user,pwd);
            	st=con.createStatement();
            	int recordCount=st.executeUpdate(UPDATE_QUERY);
            	System.out.println(recordCount+ " Record Updated Successfully");
            } catch(ClassNotFoundException e) {
            	e.printStackTrace();
            } catch(SQLException e) {
            	e.printStackTrace();
            } catch(Exception e) {
            	e.printStackTrace();
            }
            	break;
            
            case 4:try {
            	Class.forName(driver);
            	con=DriverManager.getConnection(url,user,pwd);
            	st=con.createStatement();
            	int recordCount=st.executeUpdate(DELETE_QUERY);
            	System.out.println(recordCount+" Record Deleted Successfully");
            } catch(ClassNotFoundException e) {
            	e.printStackTrace();
            } catch(SQLException e) {
            	e.printStackTrace();
            } catch(Exception e) {
            	e.printStackTrace();
            }
            	break;	
            	
            case 5:try {
            	Class.forName(driver);
            	con=DriverManager.getConnection(url,user,pwd);
            	st=con.createStatement();
            	ResultSet rs=st.executeQuery(SELECT_QUERY);
            	while(rs.next()) {
        			System.out.println(rs.getInt(1)+" "+rs.getString(2));
        		}
            } catch(ClassNotFoundException e) {
            	e.printStackTrace();
            } catch(SQLException e) {
            	e.printStackTrace();
            } catch(Exception e) {
            	e.printStackTrace();
            }
            	break;
            default:
            	System.out.println("Invalid Choise");
               
            }   
	}
	}
            
	}
