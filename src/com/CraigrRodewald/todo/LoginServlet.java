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
@WebServlet("/LoginServlet")
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("form-email");
		String userPassword = request.getParameter("form-password");

		try {
			
			System.out.println("calling server");
			System.out.println(userEmail);
			System.out.println(userPassword);
			
			if (userEmail != null && userPassword != null) {
				User user = UserDAO.checkIfMemberExists(userEmail, userPassword);

				System.out.println(user.getFirstName());
				
				if (user!=null) {
					
					System.out.println("Getting info");
					
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
			
	//		getServletContext().getRequestDispatcher("/NewMember.html").forward(request, response);
		}
		
		
	}

}
