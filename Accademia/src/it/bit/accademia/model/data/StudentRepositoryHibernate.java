package it.bit.accademia.model.data;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import it.bit.accademia.model.Course;
import it.bit.accademia.model.Iscrizione;
import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.Student;

public class StudentRepositoryHibernate extends GenericRepositoryImpl<Student> implements StudentRepository {

	public StudentRepositoryHibernate(Session s, Class<Student> c) {
		super(s , c);
	}

	@Override
	public Collection<Student> findByNameLike(String partialName) throws DataException {
		session.beginTransaction();
		Query <Student> query = session.createQuery("from Student s where s.nome like :partialName");
		query.setParameter("partialName", "%"+partialName+"%");
		List <Student> lista = query.getResultList();
		session.getTransaction().commit();
		return lista;
	}

	@Override
	public Collection<Student> findByLastNameLike(String partialLastName) throws DataException {
		session.beginTransaction();
		Query <Student> query = session.createQuery("from Student s where s.cognome like :partialLastName");
		query.setParameter("partialLastName", "%"+partialLastName+"%");
		List <Student> lista = query.getResultList();
		session.getTransaction().commit();
		return lista;
	}

	@Override
	public void iscriviStudente(int studentId, int corsoId) throws LogicException {
		session.beginTransaction();
		Student s = session.load(Student.class, studentId);
		Course c = session.load(Course.class, corsoId);
		Iscrizione isc = new Iscrizione();
		isc.setCorso(c);
	//	c.getIscrizioni().add(isc);
		isc.setStudente(s);
		session.save(isc);
		session.getTransaction().commit();
	}

	@Override
	public Collection<Student> allStudentByCourse(int corsoId) throws DataException {
		session.beginTransaction();
		Collection<Student> collection = session.load(Course.class, corsoId).getIscrizioni()
			.stream().map(Iscrizione::getStudente).collect(Collectors.toList());
//		Course c = session.load(Course.class, corsoId);
//		List <Iscrizione> iscrizioni = c.getIscrizioni();
//		List <Student> studenti = new ArrayList<Student>();
//		for(Iscrizione isc : iscrizioni) {
//			studenti.add(isc.getStudente());
//		}
		session.getTransaction().commit();
 		return collection;
	}

	@Override
	public void close() {
		session.close();
	}

}