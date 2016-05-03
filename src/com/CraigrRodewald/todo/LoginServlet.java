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
@WebServlet("/Login0.Servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("form-email");
		String userPassword = request.getParameter("form-password");

		try {
			
			if (userEmail != null && userPassword != null) {
				User user = UserDAO.checkIfMemberExists(userEmail, userPassword);

				if (user != null) {
					ArrayList<Item> todoList = ItemDAO.retrieveToDoList();
					request.setAttribute("member", (user.getFirstName() + " " + user.getLastName()));
					request.setAttribute("eventList", todoList);
					Gson gson = new Gson();
					System.out.println(gson.toJson(todoList));
					response.getWriter().append(gson.toJson(todoList));
					
					//getServletContext().getRequestDispatcher("/ToDoList.html").forward(request, (ServletResponse) response.getWriter().append(gson.toJson(todoList)));
				}
			}
			
		} catch (Exception NullPointerException) {
			
			getServletContext().getRequestDispatcher("/NewMember.html").forward(request, response);
		}
		
	}

}
