package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
//			Student myStudent = session.get(Student.class, studentId);

			
//			
//			System.out.println("Deleting :" +myStudent);
//			session.delete(myStudent);
			
			// delete id = 2
			System.out.println("del 2");
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			
			System.out.println("Done!");
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}





