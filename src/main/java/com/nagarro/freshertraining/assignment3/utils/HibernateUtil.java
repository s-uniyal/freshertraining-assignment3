/**
 * 
 */
package com.nagarro.freshertraining.assignment3.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nagarro.freshertraining.assignment3.models.Image;
import com.nagarro.freshertraining.assignment3.models.User;

/**
 * @author shashankuniyal
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static Session getSession() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Image.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		System.out.println("Hibernate Java Config serviceRegistry created");
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();

	} 
}
