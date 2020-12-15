package com.nagarro.freshertraining.assignment3.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.freshertraining.assignment3.dao.UserDao;
import com.nagarro.freshertraining.assignment3.models.User;

/**
 * Servlet implementation class Reset
 */
@WebServlet("/reset")
public class Reset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reset() {
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
		UserDao update = new UserDao();
		String username = request.getParameter("username");
		String fullname = request.getParameter("name");
		String newPassword = request.getParameter("new_password");
		String confPassword = request.getParameter("conf_password");
		User user = update.updateUser(username, newPassword, confPassword, fullname);
		if (user != null) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("register.jsp");
		}

	}

}
