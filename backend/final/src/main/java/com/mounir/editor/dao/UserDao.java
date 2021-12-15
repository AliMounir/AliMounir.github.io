package com.mounir.editor.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mounir.editor.model.User;

public class UserDao {
	
	public int registerUser(User user) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO user" +
				" (id, name, job, birthDate, address, email) VALUES " +
				" (?, ?, ?, ?, ?, ?);";
		
		int result = 0;
		int i = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
																	"root", "sql123456");
				//Step 2: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				preparedStatement.setInt(1,  i++);
				preparedStatement.setString(2, user.getName());
				preparedStatement.setString(3, user.getJob());
				preparedStatement.setString(4, user.getBirthDate());
				preparedStatement.setString(5, user.getAddress());
				preparedStatement.setString(6, user.getEmail());
				
				System.out.println(preparedStatement);
				
				//Step 3: Execute the query or update query
				result = preparedStatement.executeUpdate();
				
		} catch (SQLException e) {
			//process sql exception
			e.printStackTrace();;
		}
		
		return result;
	}

}
