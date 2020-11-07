package it.bit.accademia.model.data;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.Student;

public class GenericRepositoryImpl<T> implements GenericRepository<T> {
	protected Session session;
	private Class<T> c;
	public GenericRepositoryImpl(Session s, Class<T> cl){
		session = s;
		c = cl;
	}
	
	@Override
	public T add(T t) throws DataException {
		try {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
			return t;
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new DataException(e.getMessage(), e);
		}

	}

	@Override
	public T delete(int id) throws DataException, LogicException {
		try {
			session.beginTransaction();
			T t = session.load(c, id);
			session.delete(t);
			session.getTransaction().commit();
			return t;
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new DataException(e.getMessage(), e);
		} catch(EntityNotFoundException e) {
			throw new LogicException("Stai cercando di cancellare uno studente che non esiste con id: "+id);
		}
	}

	@Override
	public void update(T t) throws DataException {
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
	}

	@Override
	public Optional<T> findById(int id) throws DataException{
		session.beginTransaction();
		T t = session.get(c, id);
		session.getTransaction().commit();
		return Optional.ofNullable(t);
	}

	@Override
	public Collection<T> findAll() {
		session.beginTransaction();
		List<T> lista = session.createQuery("from "+c.getSimpleName()).getResultList();
		session.getTransaction().commit();
		return lista;
	}

	@Override
	public void close() throws Exception {
		session.close();
		
	}

}
