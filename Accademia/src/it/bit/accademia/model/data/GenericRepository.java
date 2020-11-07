package it.bit.accademia.model.data;

import java.util.Collection;
import java.util.Optional;


public interface GenericRepository<T> extends AutoCloseable{
	T add(T t) throws Exception;
	T delete(int id) throws Exception;
	void update(T t) throws Exception;
	Optional<T> findById(int id) throws Exception;
	Collection<T> findAll() throws Exception;
}
