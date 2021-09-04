package com.raven.demo;

import com.raven.entity.Instructor;
import com.raven.entity.InstructorDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiCreateDemo {
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome One-To-One Bi-directional Mapping Demo!!!");
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			// GET INSTRUCTOR
			int id = 4;
			InstructorDetails instructorDetails = session.get(InstructorDetails.class, id);
			if (instructorDetails != null) {
				System.out.println("Found Instructor Details :: " + instructorDetails);
				System.out.println("Found Instructor :: " + instructorDetails.getInstructor());
			}

			session.getTransaction().commit();
			System.out.println("Done!!!");
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
