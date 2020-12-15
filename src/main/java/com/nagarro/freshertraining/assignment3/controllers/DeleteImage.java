package com.nagarro.freshertraining.assignment3.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.freshertraining.assignment3.dao.ImageDao;

/**
 * Servlet implementation class DeleteImage
 */
@WebServlet("/delete")
public class DeleteImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
        } else {
 
            ImageDao deletion = new ImageDao();
            String imageId = request.getParameter("imageId");
           
            deletion.deleteImage(imageId);
            System.out.println(imageId + "deleted");
//            User userUpdated = login.getUserDetails(((User) request.getSession().getAttribute("user")).getUsername());
//            request.getSession().setAttribute("user", userUpdated);
            response.sendRedirect("RetrieveImage");
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
