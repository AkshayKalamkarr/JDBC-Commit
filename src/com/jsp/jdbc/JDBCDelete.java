package com.jsp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDelete {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";

		String sql = "DELETE FROM STUDENT WHERE ID=1";
		Connection connection = null;
		try {

			// load/register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// established connection
			connection = DriverManager.getConnection(url, username, password);

			// create statement
			Statement statement = connection.createStatement();

			// execute statement
			int res= statement.executeUpdate(sql);
			
			if(res>0) {
				System.out.println("object deleted");
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
