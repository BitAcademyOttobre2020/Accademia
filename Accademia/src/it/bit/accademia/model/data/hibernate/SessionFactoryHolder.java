package it.bit.accademia.model.data.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.bit.accademia.model.Aula;
import it.bit.accademia.model.Azienda;
import it.bit.accademia.model.Course;
import it.bit.accademia.model.Iscrizione;
import it.bit.accademia.model.Student;

public class SessionFactoryHolder {
	private static SessionFactoryHolder sfh;
	private SessionFactory factory;
	private SessionFactoryHolder() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Iscrizione.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Aula.class)
				.addAnnotatedClass(Azienda.class)
				.buildSessionFactory();
	}
	public static SessionFactoryHolder getInstance() {
		//double checked locking
		if(sfh == null) {	
			synchronized(SessionFactoryHolder.class) {
				if(sfh == null) {	
					sfh = new SessionFactoryHolder();
				}
			}
		}
		return sfh;
	}
	public static void f() {
		
	}
	public Session openSession() {
		return factory.openSession();
	}
	public void close() {
		factory.close();
	}
}
