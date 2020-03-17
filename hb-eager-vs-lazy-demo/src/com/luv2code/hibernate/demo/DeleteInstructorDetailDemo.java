package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			//get instructor detail
			int theId = 3;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			//print detail
			System.out.println("tempInstructorDetail : " +tempInstructorDetail);
			
			//print instructor
	    	System.out.println("tempInstructor: " + tempInstructorDetail.getInstructor());
	    	
	    	//delete
	    	System.out.println("Deleting tempInstructorDetail" + tempInstructorDetail);
	    	//remove the associated object refference
	    	// break bi-directional link
	    	tempInstructorDetail.getInstructor().setInstructorDetail(null);
	    	session.delete(tempInstructorDetail);
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc) {
			session.close();
		}
		finally {
			factory.close();
		}
	}

}





