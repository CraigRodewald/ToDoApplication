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
			preparedStatement = connect.prepareStatement("SELECT * FROM library.calendar");
			resultSet = preparedStatement.executeQuery();

			System.out.println("Upcoming events:");

			while (resultSet.next()) {
				Item item = new Item();
				item.setItemName(resultSet.getString("event_name"));
				todoList.add(item);
			}

			for (Item item: todoList) {
				System.out.println(item.getItemName());
			}

			return todoList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
