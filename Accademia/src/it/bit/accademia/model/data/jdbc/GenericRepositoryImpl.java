package it.bit.accademia.model.data.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.Student;
import it.bit.accademia.model.data.DataException;

public abstract class GenericRepositoryImpl<T> implements GenericRepository<T> {

	protected Map<QueryType, String> queryMap = new HashMap<QueryType, String>();
	protected Map<QueryType, PreparedStatementSetter<T>> statementSetterMap = new HashMap<QueryType, PreparedStatementSetter<T>>();
	protected ResultSetMapper<T> resultSetMapper;
	
	//initialize queryMap, statementMap
	//metodo astratto entityResultSetMap
	
	public void addQuery(QueryType type, String sql) {
		queryMap.put(type, sql);
	}

	public void addStatementSetter(QueryType type, PreparedStatementSetter setter) {
		statementSetterMap.put(type, setter);
	}

	@Override
	public T add(T t) throws DataException {
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement(queryMap.get(QueryType.CREATE));

		) {
//			pst.setInt(1, studente.getId());
//			pst.setString(2, studente.getNome());
//			pst.setString(3, studente.getCognome());
//			pst.setString(4, studente.getDataDiNascita());
//			pst.setString(5, studente.getCF());
//			pst.setString(6, studente.getEmail());
//			pst.setString(7, studente.getTelefono());
//			pst.setString(8, studente.getCitta());
//			pst.setString(9, studente.getVia());
//			pst.setString(10, studente.getCap());
//			pst.setInt(11, studente.getIdRegione());
//			pst.setString(12, studente.getTitoloStudio());

			statementSetterMap.get(QueryType.CREATE).setParams(pst, t, 0);
			pst.execute();
			return t;
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}
	}

	@Override
	public T delete(int id) throws DataException, LogicException {
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement(queryMap.get(QueryType.DELETE));

		) {
			Optional<T> t = findById(id);
			if (t.isEmpty()) {
				throw new LogicException("Non puoi cancellare un elemento che non esiste!");
			}

//			pst.setInt(1, id);
			statementSetterMap.get(QueryType.DELETE).setParams(pst, t.get(), 0);
			pst.execute();
			return t.get();
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}

	}

	@Override
	public void update(T t) throws DataException {
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement(queryMap.get(QueryType.UPDATE));

		) {
			statementSetterMap.get(QueryType.UPDATE).setParams(pst, t, 0);
			pst.execute();
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}
	}

	@Override
	public Optional<T> findById(int id) throws DataException {
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement(queryMap.get(QueryType.FIND_BY_ID));

		) {
			statementSetterMap.get(QueryType.FIND_BY_ID).setParams(pst, null, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				T t = resultSetMapper.mapToEntity(rs);
				return Optional.of(t);
			} else {
				return Optional.empty();
			}

		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}		
	}

	@Override
	public Collection<T> findAll() throws DataException {
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement(queryMap.get(QueryType.READ));

		) { 
			Collection<T> results = new ArrayList<T>();
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				results.add(resultSetMapper.mapToEntity(rs));
			} 
			return results;

		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}			
	}

}
