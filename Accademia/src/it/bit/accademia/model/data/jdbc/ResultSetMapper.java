package it.bit.accademia.model.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetMapper<T> {

	T mapToEntity(ResultSet rs) throws SQLException;
}
