package com.nagarro.freshertraining.assignment3.controllers;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.freshertraining.assignment3.dao.ImageDao;
import com.nagarro.freshertraining.assignment3.models.Image;
import com.nagarro.freshertraining.assignment3.models.User;

/**
 * Servlet implementation class RetrieveImage
 */
@WebServlet("/RetrieveImage")
public class RetrieveImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("index.jsp");
		} else {
			ImageDao retriever = new ImageDao();
			Collection<Image> images = retriever.getImages(user);
			request.getSession().setAttribute("images", images);
			response.sendRedirect("images.jsp");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user.getId());
	}

}
