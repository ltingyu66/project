package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCourseForMaryDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
	        //get Mary
			int studentID =2;
			Student temptStudent = session.get(Student.class, studentID);
			
			System.out.println("\nLoaded student: " +temptStudent);
			System.out.println("Courses " +temptStudent.getCourses());
			
			//create courses
			Course tempCourse1 = new Course("Riks Cube");
			Course tempCourse2 = new Course("Dance");
			
			//add student to courses
			tempCourse1.addStudent(temptStudent);
			tempCourse2.addStudent(temptStudent);
			
			System.out.println("\nSaving the courses...");
			
			//save the course
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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





