package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;



public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			/*
			//create the object
			Instructor tempInstructor = new Instructor("Francu", "Adrian", "adryan15a@yahoo.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 code!!!");
			*/
			
			Instructor tempInstructor = new Instructor("Viorica", "Dancila", "psd@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.psd.com/youtube","I steal alot");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start tranzaction
			session.beginTransaction();
			
			//save the instructor
			//
			//Note:this will ALSO save the details object
			//because of CascadeType.ALL
			//
			System.out.println("Saving instructor " + tempInstructor);
			session.save(tempInstructor);
			
			//commit tranzaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
