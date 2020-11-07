package it.bit.accademia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.bit.accademia.model.Course;
import it.bit.accademia.model.Iscrizione;
import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.Student;
import it.bit.accademia.model.data.DataException;
import it.bit.accademia.model.data.StudentRepository;
import it.bit.accademia.model.data.StudentRepositoryHibernate;
import it.bit.accademia.model.data.hibernate.SessionFactoryHolder;


public class MainHibernate {

	public static void main(String[] args) {
			
		try (Session session = SessionFactoryHolder.getInstance().openSession();
			StudentRepositoryHibernate sr = new StudentRepositoryHibernate(session , Student.class);){
//				.configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Iscrizione.class)
//				.addAnnotatedClass(Course.class)
//				.addAnnotatedClass(Student.class)
//				.buildSessionFactory();
//			 Session session = factory.getCurrentSession();){			
			
			// start a transaction
			
			// get the student mary from database
			Student tempStudent = new Student(5, "paolo", "claudino", "20000909", "ciiao", "claudiodsa@gmail.com", "323412325", "Milano", "via claudio", "21333", 1, "Impiegato");
			Student tempStudent2 = new Student(5, "cluadio", "paolino", "20000909", "ciiao", "cldsa@gmail.com", "323712325", "Milano", "via claudio", "21333", 1, "Impiegato");
			sr.allStudentByCourse(1).forEach(System.out::println);
			
	//		sr.add(tempStudent);
	//		sr.delete(5);
	//		System.out.println("\nLoaded student: " + tempStudent);
	//		tempStudent.setNome("Giovanni");
		//	sr.update(tempStudent2);
			
//			session.save(tempStudent);
//						
//			session.getTransaction().commit();
		//	Student s =session.load(Student.class, 2);	//.class e chiave primaria
		//	session.delete(session.load(Student.class, 2));
			// create more courses 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
