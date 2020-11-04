package it.bit.accademia.model.data.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementSetter<T> {

	void setParams(PreparedStatement ps, T t, int key) throws SQLException;
}
