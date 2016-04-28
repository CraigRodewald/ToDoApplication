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
					.prepareStatement("INSERT INTO patrons (first_name, last_name, email, password) VALUES (?,?,?)");
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
				String userEmail = resultSet.getString("email");
				System.out.println(userEmail);
				if (userEmail.equalsIgnoreCase(email)) {
					User user = new User();
					user.setFirstName(resultSet.getString("first_name"));
					user.setLastName(resultSet.getString("last_name"));
					user.setUserEmail(resultSet.getString("email"));
					user.setUserPassword(resultSet.getString("password"));
					return user;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
