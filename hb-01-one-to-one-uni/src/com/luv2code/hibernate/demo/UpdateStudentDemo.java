package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			int studentId = 1;
			
			// new session and transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve  student based on the id
			System.out.println("\nGetting student with id:" + studentId);;
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("updating student ");
			myStudent.setFirstName("Scooby");
			session.getTransaction().commit();
			
			// new
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}





