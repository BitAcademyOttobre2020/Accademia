package it.bit.accademia.model.data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import it.bit.accademia.model.Area;
import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.Student;
import it.bit.accademia.model.data.DataException;
import it.bit.accademia.model.data.StudentRepository;

public class StudentRepositoryJdbc implements StudentRepository {

	@Override
	public Student add(Student studente) throws DataException {
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement("INSERT INTO scuola.Studenti (id, nome, "
						+ "cognome, data_di_nascita, CF, email, telefono, citta, via, cap, id_regione,"
						+ " titolo_studio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		) {
			pst.setInt(1, studente.getId());
			pst.setString(2, studente.getNome());
			pst.setString(3, studente.getCognome());
			pst.setString(4, studente.getDataDiNascita());
			pst.setString(5, studente.getCF());
			pst.setString(6, studente.getEmail());
			pst.setString(7, studente.getTelefono());
			pst.setString(8, studente.getCitta());
			pst.setString(9, studente.getVia());
			pst.setString(10, studente.getCap());
			pst.setInt(11, studente.getIdRegione());
			pst.setString(12, studente.getTitoloStudio());

			pst.execute();
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}
		return studente;
	}

	@Override
	public Student delete(int id) throws LogicException, DataException {
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement("DELETE FROM scuola.Studenti WHERE id = ?;");

		) {
			Optional<Student> s = findById(id);
			if (s.isEmpty()) {
				throw new LogicException("Non puoi cancellare uno studente che non esiste!");
			}

			pst.setInt(1, id);

			pst.execute();
			return s.get();
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}

	}

	@Override
	public Collection<Student> findAll() throws DataException {
		Collection<Student> lista = new ArrayList<Student>();
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM scuola.Studenti;");) {

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					int idStudente = rs.getInt("id");
					String nome = rs.getString("nome");
					String cognome = rs.getString("cognome");
					String dataDiNascita = rs.getString("data_di_nascita");
					String CF = rs.getString("CF");
					String email = rs.getString("email");
					String telefono = rs.getString("telefono");
					String citta = rs.getString("citta");
					String via = rs.getString("via");
					String cap = rs.getString("cap");
					int idRegione = rs.getInt("id_regione");
					String titoloStudio = rs.getString("titolo_studio");
					Student st = new Student(idStudente, nome, cognome, dataDiNascita, CF, email, telefono, citta, via,
							cap, idRegione, titoloStudio);
					lista.add(st);
				}
				return lista;
			}
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}

	}

	@Override
	public Collection<Student> findByNameLike(String partialName) throws DataException {
		Collection<Student> lista = new ArrayList<Student>();
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM scuola.Studenti WHERE nome LIKE ?;");) {
			pst.setString(1, "%" + partialName + "%");
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					int idStudente = rs.getInt("id");
					String nome = rs.getString("nome");
					String cognome = rs.getString("cognome");
					String dataDiNascita = rs.getString("data_di_nascita");
					String CF = rs.getString("CF");
					String email = rs.getString("email");
					String telefono = rs.getString("telefono");
					String citta = rs.getString("citta");
					String via = rs.getString("via");
					String cap = rs.getString("cap");
					int idRegione = rs.getInt("id_regione");
					String titoloStudio = rs.getString("titolo_studio");
					Student st = new Student(idStudente, nome, cognome, dataDiNascita, CF, email, telefono, citta, via,
							cap, idRegione, titoloStudio);
					lista.add(st);
				}
				return lista;
			}
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}
	}

	@Override
	public Collection<Student> findByLastNameLike(String partialLastname) throws DataException {
		Collection<Student> lista = new ArrayList<Student>();
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM scuola.Studenti WHERE cognome LIKE ?;");) {
			pst.setString(1, "%" + partialLastname + "%");
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					int idStudente = rs.getInt("id");
					String nome = rs.getString("nome");
					String cognome = rs.getString("cognome");
					String dataDiNascita = rs.getString("data_di_nascita");
					String CF = rs.getString("CF");
					String email = rs.getString("email");
					String telefono = rs.getString("telefono");
					String citta = rs.getString("citta");
					String via = rs.getString("via");
					String cap = rs.getString("cap");
					int idRegione = rs.getInt("id_regione");
					String titoloStudio = rs.getString("titolo_studio");
					Student st = new Student(idStudente, nome, cognome, dataDiNascita, CF, email, telefono, citta, via,
							cap, idRegione, titoloStudio);
					lista.add(st);
				}
				return lista;
			}
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}
	}

	@Override
	public Optional<Student> findById(int id) throws DataException {
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement("SELECT * FROM scuolacorsi.Studenti WHERE id = ?;");

		) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					int idStudente = rs.getInt("id");
					String nome = rs.getString("nome");
					String cognome = rs.getString("cognome");
					String dataDiNascita = rs.getString("data_di_nascita");
					String CF = rs.getString("CF");
					String email = rs.getString("email");
					String telefono = rs.getString("telefono");
					String citta = rs.getString("citta");
					String via = rs.getString("via");
					String cap = rs.getString("cap");
					int idRegione = rs.getInt("id_regione");
					String titoloStudio = rs.getString("titolo_studio");

					Student st = new Student(idStudente, nome, cognome, dataDiNascita, CF, email, telefono, citta, via,
							cap, idRegione, titoloStudio);

					return Optional.of(st);
				} else {
					return Optional.empty();
				}
			}
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}

	}

	@Override
	public void update(Student studente) throws DataException {
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement("UPDATE scuola.Studenti SET id=?, "
						+ "nome=?, cognome=?, data_di_nascita=?, CF=?, email=?, telefono=?, "
						+ "citta=?, via=?, cap=?, id_regione=?, titolo_studio=? WHERE id=?");

		) {
			pst.setInt(1, studente.getId());
			pst.setString(2, studente.getNome());
			pst.setString(3, studente.getCognome());
			pst.setString(4, studente.getDataDiNascita());
			pst.setString(5, studente.getCF());
			pst.setString(6, studente.getEmail());
			pst.setString(7, studente.getTelefono());
			pst.setString(8, studente.getCitta());
			pst.setString(9, studente.getVia());
			pst.setString(10, studente.getCap());
			pst.setInt(11, studente.getIdRegione());
			pst.setString(12, studente.getTitoloStudio());
			pst.setInt(13, studente.getId());
			pst.execute();
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}
	}

	@Override
	public void iscriviStudente(int studentId, int corsoId) throws LogicException {
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con
						.prepareStatement("INSERT INTO scuola.iscrizioni (id_corso, " + "id_studente) VALUES (?, ?)");

		) {
			pst.setInt(1, corsoId);
			pst.setInt(2, studentId);
			pst.execute();
		} catch (SQLException e) {
			throw new LogicException(e.getMessage());
		}
	}

	@Override
	public Collection<Student> allStudentByCourse(int corsoId) throws DataException {
		Collection<Student> lista = new ArrayList<Student>();
		try (Connection con = JdbcHelper.createConnection();
				PreparedStatement pst = con.prepareStatement(
						"SELECT s.id AS id_studente, nome, cognome, data_di_nascita, CF, email, telefono, citta, via, cap, id_regione, titolo_studio FROM scuola.Studenti AS s INNER JOIN scuola.iscrizioni AS i ON s.id=i.id_studente WHERE id_corso = ? ;");) {
			pst.setInt(1, corsoId);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					int idStudente = rs.getInt("id_studente");
					String nome = rs.getString("nome");
					String cognome = rs.getString("cognome");
					String dataDiNascita = rs.getString("data_di_nascita");
					String CF = rs.getString("CF");
					String email = rs.getString("email");
					String telefono = rs.getString("telefono");
					String citta = rs.getString("citta");
					String via = rs.getString("via");
					String cap = rs.getString("cap");
					int idRegione = rs.getInt("id_regione");
					String titoloStudio = rs.getString("titolo_studio");
					Student st = new Student(idStudente, nome, cognome, dataDiNascita, CF, email, telefono, citta, via,
							cap, idRegione, titoloStudio);
					lista.add(st);
				}
				return lista;
			}
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}

	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
