package com.nagarro.freshertraining.assignment3.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nagarro.freshertraining.assignment3.dao.ImageDao;
import com.nagarro.freshertraining.assignment3.models.Image;
import com.nagarro.freshertraining.assignment3.models.User;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet("/upload")
public class UploadImage extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int maxFileSize = 1024;
	private static final int totalMaxSize = 10240;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ImageDao imageUtil = new ImageDao();
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		} else {
			// if user is not null.

			String imageName = null;
			byte imageBytes[] = null;
			double imageSize = 0;
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				// Check if content is multipart in form
				FileItemFactory factory = new DiskFileItemFactory();
				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				try {
					List<FileItem> multiparts = upload.parseRequest(request);
					for (FileItem item : multiparts) {
						if (item.isFormField()) {
							// get image name entered by user.
							imageName = item.getString();
						} else {
							// get size of image selected by user.
							imageSize = item.getSize() / maxFileSize;
							// save image into byte array.
							imageBytes = item.get();
						}
					}

					User user = (User) request.getSession().getAttribute("user");
					Image image = new Image();
					image.setImage(imageBytes);
					image.setImageName(imageName);
					image.setImageSize(imageSize);
					image.setUser(user);
					int userId = user.getId();
					if (imageUtil.getImagesSize(userId) < totalMaxSize && image.getImageSize() < maxFileSize) {
						// save image to database after checking
						// image size and total images size
						imageUtil.saveImage(image);
						response.sendRedirect("RetrieveImage");
					} else {
						response.sendError(maxFileSize, "Size limit Exceeded");
					}
//					request.getSession().setAttribute("image", image);
//					 RequestDispatcher rd = request.getRequestDispatcher("RetrieveImage");
//					 rd.forward(request, response);

				} catch (Exception e) {
					// FIXME show exception why image could not be uploaded
					e.printStackTrace();
				}
			} 
		}
	}
}
