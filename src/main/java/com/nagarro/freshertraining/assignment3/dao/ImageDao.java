/**
 * 
 */
package com.nagarro.freshertraining.assignment3.dao;

import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.freshertraining.assignment3.models.Image;
import com.nagarro.freshertraining.assignment3.models.User;
import com.nagarro.freshertraining.assignment3.utils.HibernateUtil;

/**
 * @author shashankuniyal
 *
 */
public class ImageDao {

//	total size of images
	public double getImagesSize(int userId) {
		double totalSize = 0;
		UserDao login = new UserDao();
		User user = login.getUser(userId);
		Collection<Image> images = user.getImages();
		for (Image image : images) {
			totalSize += image.getImageSize();
		}
		return totalSize;
	}

//	save image to database

	public Image saveImage(Image image) {
		try (Session session = HibernateUtil.getSession();) {
			Transaction transaction = null;

			transaction = session.beginTransaction();
			session.save(image);
			transaction.commit();
			return image;
		}
	}

	public Collection<Image> getImages(User user) {
		Collection<Image> images = null;
		try (Session session = HibernateUtil.getSession();) {
			session.getTransaction().begin();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria

			CriteriaQuery<Image> criteria = builder.createQuery(Image.class);
			Root<Image> imageRoot = criteria.from(Image.class);
			criteria.select(imageRoot).where(builder.equal(imageRoot.get("user"), user.getId()));
			images = session.createQuery(criteria).list();
			return images;
		}
	}

	public void deleteImage(String imageId) {
		try (Session session = HibernateUtil.getSession();) {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaDelete<Image> criteriaDelete = builder.createCriteriaDelete(Image.class);
			Root<Image> rootImage = criteriaDelete.from(Image.class);
			criteriaDelete.where(builder.equal(rootImage.get("imageId"), imageId));
			session.createQuery(criteriaDelete).executeUpdate();

			System.out.println("this query ran");

			session.getTransaction().commit();
		}
	}


	public void editImage(String imageName, byte[] imageBytes, User user, double size, int imageId) {
		try (Session session = HibernateUtil.getSession();) {
			session.beginTransaction();
			Image newImage = session.load(Image.class, imageId);
			newImage.setImage(imageBytes);
			newImage.setImageName(imageName);
			newImage.setImageSize(size);
//			newImage.setUser(user);
			session.update(newImage);
			session.getTransaction().commit();
//			session.refresh(newImage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
