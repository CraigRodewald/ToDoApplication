package com.CraigrRodewald.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO {
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static ArrayList<Item> retrieveToDoList() {

		try {
			ArrayList<Item> todoList = new ArrayList<>();
			Connection connect = DAOConnection.startConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM todolist.items");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Item item = new Item();
				item.setItemName(resultSet.getString("item_name"));
				todoList.add(item);
			}

			return todoList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void addNewItemToDatabase(Item newItem) {

		try {
			Connection connect = DAOConnection.startConnection();
			
			preparedStatement = connect
					.prepareStatement("INSERT INTO items (item_name) VALUES (?)");
			preparedStatement.setString(1, newItem.getItemName());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
