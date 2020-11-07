package it.bit.accademia.model.data.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.bit.accademia.model.Course;

public class CourseRepository extends GenericRepositoryImpl<Course>{

	public final static String CREATE_COURSE = "INSERT INTO corsi (id, nome_corso, "
			+ "id_aula_pref, capienza, iscrizioni_min, finanziato, id_azienda) VALUES (?, ?, ?, ?, ?, ?, ?)";

	public final static String READ_ALL_COURSES = "SELECT id, nome_corso, "
			+ "id_aula_pref, capienza, iscrizioni_min, finanziato, id_azienda "
			+ "FROM corsi";

	public final static String UPDATE_COURSE = "UPDATE corsi SET id=?, nome_corso=?, id_aula_pref=?, "
			+ "capienza=?, iscrizioni_min=?, finanziato=?, id_azienda=? WHERE id=?";
	
	public final static String DELETE_COURSE = "DELETE FROM corsi WHERE id=?";
	
	public final static String FIND_COURSE_BY_ID = "SELECT id, nome_corso, "
			+ "id_aula_pref, capienza, iscrizioni_min, finanziato, id_azienda "
			+ "FROM corsi WHERE id=?";
	
	public CourseRepository() {
		this.queryMap.put(QueryType.CREATE, CREATE_COURSE);
		this.queryMap.put(QueryType.READ, READ_ALL_COURSES);
		this.queryMap.put(QueryType.UPDATE, UPDATE_COURSE);
		this.queryMap.put(QueryType.DELETE, DELETE_COURSE);
		this.queryMap.put(QueryType.FIND_BY_ID, FIND_COURSE_BY_ID);

		this.statementSetterMap.put(QueryType.CREATE, CourseRepository::createStatementSetter);
		this.statementSetterMap.put(QueryType.DELETE, (p,c,i)->p.setInt(1,c.getId()));
		this.statementSetterMap.put(QueryType.FIND_BY_ID, (p,c,i)->p.setInt(1, i));
		this.statementSetterMap.put(QueryType.UPDATE, CourseRepository::updateStatementSetter);

		this.resultSetMapper = this::courseResultSetMap;
	}
	
	private static void createStatementSetter(PreparedStatement pst, Course c, int key) throws SQLException {
		pst.setInt(1,c.getId());
		pst.setString(2,c.getNomeCorso());
		pst.setInt(3, c.getAulaPreferita().getId());
		pst.setInt(4, c.getCapienza());
		pst.setInt(5, c.getIscrizioneMin());
		pst.setBoolean(6, c.isFinanziato());
		pst.setInt(7, c.getAzienda().getId());
		
	}
	
	private Course courseResultSetMap(ResultSet rs) throws SQLException {
//		return new Course(rs.getInt("id"), rs.getString("nome_corso"), rs.getInt("id_aula_pref"),
//				rs.getInt("capienza"), rs.getInt("iscrizioni_min"), rs.getBoolean("finanziato"),
//				rs.getInt("id_azienda"));
//		
		return null;
	}

	private static void updateStatementSetter(PreparedStatement pst, Course c, int key) throws SQLException {
		createStatementSetter(pst, c, key);
		pst.setInt(8,c.getId());
		
		
	}
}

