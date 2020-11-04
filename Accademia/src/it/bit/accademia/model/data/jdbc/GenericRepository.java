package it.bit.accademia.model.data.jdbc;

import java.util.Collection;
import java.util.Optional;

import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.data.DataException;

public interface GenericRepository<T> {

	T add(T t) throws DataException;

	T delete(int id) throws DataException, LogicException;

	void update(T t) throws DataException;

	Optional<T> findById(int id) throws DataException;

	Collection<T> findAll() throws DataException;

}
