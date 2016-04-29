package com.CraigrRodewald.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet= null;
	
	public static void addNewUserToDatabase(User newUser) {

		try {
			Connection connect = DAOConnection.startConnection();
			
			preparedStatement = connect
					.prepareStatement("INSERT INTO users (first_name, last_name, email, password) VALUES (?,?,?)");
			preparedStatement.setString(1, newUser.getFirstName());
			preparedStatement.setString(2, newUser.getLastName());
			preparedStatement.setString(3, newUser.getUserEmail());
			preparedStatement.setString(3, newUser.getUserPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static User checkIfMemberExists(String email, String password) {
		try {
			Connection connect =DAOConnection.startConnection();
			preparedStatement = connect
					.prepareStatement("SELECT * FROM todolist.users");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String userEmail = resultSet.getString("user_email");
				if (userEmail.equalsIgnoreCase(email)) {
					User user = new User();
					user.setFirstName(resultSet.getString("first_name"));
					user.setLastName(resultSet.getString("last_name"));
					user.setUserEmail(resultSet.getString("user_email"));
					user.setUserPassword(resultSet.getString("user_password"));
					System.out.println("User Found!");
					return user;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
