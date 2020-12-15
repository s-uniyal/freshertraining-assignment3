/**
 * 
 */
package com.nagarro.freshertraining.assignment3.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.freshertraining.assignment3.models.User;
import com.nagarro.freshertraining.assignment3.utils.HibernateUtil;

/**
 * @author shashankuniyal
 *
 */
public class UserDao {

	public void saveUser(User user) {
		try (Session session = HibernateUtil.getSession();) {
			Transaction transaction = null;
			// start a transaction
			transaction = session.beginTransaction();
			// save the user object
			session.save(user);
			// commit transaction
			transaction.commit();
		}

	}
	public User getUser(int id) {
        User user = null;
        try (Session session = HibernateUtil.getSession();) {
            session.getTransaction().begin();
            user = session.get(User.class, id);
            return user;
        }

    }

	public User authenticate(String username, String password) {
		try (Session session = HibernateUtil.getSession();) {
			session.getTransaction().begin();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria

			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> userRoot = criteria.from(User.class);
			criteria.select(userRoot).where(builder.equal(userRoot.get("username"), username));

			User user = (User) session.createQuery(criteria).uniqueResult();
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				return null;

			}
		}
	}

	public User updateUser(String username, String newPassword, String confPassword, String fullname) {
		try (Session session = HibernateUtil.getSession();) {
			Transaction transaction = null;
			// start a transaction
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create Criteria

			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> userRoot = criteria.from(User.class);
			criteria.select(userRoot).where(builder.equal(userRoot.get("username"), username));
			// update the user object
			User user = (User) session.createQuery(criteria).uniqueResult();
//			User updateUser = session.get(User.class, user.getId());
//			System.out.println(user.getName());
			if (user.getName().equals(fullname) && confPassword.equals(newPassword)) {
				user.setPassword(newPassword);
				session.update(user);
				transaction.commit();
			}
			return user;

		}
	}

}
