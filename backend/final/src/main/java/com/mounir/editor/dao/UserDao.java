package com.mounir.editor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mounir.editor.model.User;

public class UserDao {

	public int registerUser(User user) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO user " + "(name, job, address, birthDate, email, number, insta, github, aboutMe) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

		int result = 0;
		int i = 0;
		int lastInsertedId = 0;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
				"root", "sql123456");
				// Step 2: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL,
						Statement.RETURN_GENERATED_KEYS)) {
//				preparedStatement.setInt(1,  i++);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getJob());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getBirthDate());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getNumber());
			preparedStatement.setString(7, user.getInsta());
			preparedStatement.setString(8, user.getGithub());
			preparedStatement.setString(9, user.getAboutMe());

			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				lastInsertedId = rs.getInt(1);
			}

		} catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
		}

		return lastInsertedId;
	}

	public List<User> getUsers() {


		String SQL_SELECT = "SELECT * FROM user";

		int result = 0;
		int i = 0;
		int lastInsertedId = 0;

		List<User> users = new ArrayList<User>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
				"root", "sql123456")) {

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String job = resultSet.getString("job");
				String address = resultSet.getString("address");
				String birthDate = resultSet.getString("birthDate");
				String email = resultSet.getString("email");
				String number = resultSet.getString("number");
				String insta = resultSet.getString("insta");
				String github = resultSet.getString("github");
				String aboutMe = resultSet.getString("aboutMe");


				User obj = new User();
				obj.setId(id);
				obj.setName(name);
				obj.setJob(job);
				obj.setBirthDate(birthDate);
				obj.setAddress(address);
				obj.setEmail(email);
				obj.setNumber(number);
				obj.setInsta(insta);
				obj.setGithub(github);
				obj.setAboutMe(aboutMe);

				
				users.add(obj);

			}

		} catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
		}

		return users;
	}

	public User getDefaultUser() {


		String SQL_SELECT = "SELECT * FROM user WHERE name='Ali Mounir'";

		int result = 0;
		int i = 0;
		int lastInsertedId = 0;

		User obj = new User();


		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
				"root", "sql123456")) {

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String job = resultSet.getString("job");
				String address = resultSet.getString("address");
				String birthDate = resultSet.getString("birthDate");
				String email = resultSet.getString("email");
				String number = resultSet.getString("number");
				String insta = resultSet.getString("insta");
				String github = resultSet.getString("github");
				String aboutMe = resultSet.getString("aboutMe");


				obj.setId(id);
				obj.setName(name);
				obj.setJob(job);
				obj.setBirthDate(birthDate);
				obj.setAddress(address);
				obj.setEmail(email);
				obj.setNumber(number);
				obj.setInsta(insta);
				obj.setGithub(github);
				obj.setAboutMe(aboutMe);

			}

		} catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
		}

		return obj;
	}
}
