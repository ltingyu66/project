package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			Instructor tempInstructor =
					new Instructor("SuSan","Public", "susan@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"http://www.youtube.com/Game", 
					"vedio Gamer");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
					
			
			//associate
			
			// start a transaction
			session.beginTransaction();
			
			//save
			// save details because of CasscadeTypq.ALL
			System.out.println("Saving instructor " +tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			session.close();
			
			factory.close();
		}
	}

}





