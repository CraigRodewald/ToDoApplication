package com.CraigrRodewald.todo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ToDoListServlet
 */
@WebServlet("/ToDoListServlet")
public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToDoListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userItem = request.getParameter("form-todo_item");
		try {

			if (!(userItem.equals(null))) {
				Item newItem = new Item();
				newItem.setItemName(userItem);
				ItemDAO.addNewItemToDatabase(newItem);
				
				ArrayList<Item> todoList = ItemDAO.retrieveToDoList();
				request.setAttribute("todoList", todoList);
				Gson gson = new Gson();
				System.out.println(gson.toJson(todoList));
				response.getWriter().append(gson.toJson(todoList));

				
			}

		}catch(

	Exception NullPointerException)
	{

		getServletContext().getRequestDispatcher("/NewMember.html").forward(request, response);
	}
}

}
