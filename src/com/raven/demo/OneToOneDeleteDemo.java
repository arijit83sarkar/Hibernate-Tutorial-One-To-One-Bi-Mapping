package com.raven.demo;
import com.raven.entity.Instructor;
import com.raven.entity.InstructorDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDeleteDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome One-To-One Mapping Demo!!!");
        SessionFactory sessionFactory = null;
        Session session = null;

        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            // GET INSTRUCTOR
            int id = 4;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Found Instructor :: " + instructor);

            // DELETE
            // THIS WILL ALSO DELETE THE INSTRUCTOR_DETAILS AS CascadeType.All IN INSTRUCTOR
            if (instructor != null) {
                session.delete(instructor);
            }

            session.getTransaction().commit();
            System.out.println("Done!!!");
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
