package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class TestGetAll {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";

		String sql = "select * from student";
		Connection connection = null;
		try {

			// load/register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// established 
			connection = DriverManager.getConnection(url, username, password);

			// create statement
			Statement statement = connection.createStatement();

			// execute statement
			ResultSet r= statement.executeQuery(sql);
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getString(3));
				System.out.println("============");
			}
			
			
			// close the statement
			connection.close();
			System.out.println("all good");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				connection.close();
			System.out.println("Finally closed");

		}

	}
	}


