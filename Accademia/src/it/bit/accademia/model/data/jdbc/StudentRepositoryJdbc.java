package it.bit.accademia.model.data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import it.bit.accademia.model.Area;
import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.Student;
import it.bit.accademia.model.data.DataException;
import it.bit.accademia.model.data.StudentRepository;

public class StudentRepositoryJdbc implements StudentRepository {

	@Override
	public Student add(Student studente) throws DataException {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolacorsi", "root",
				"1qaz2wsx");
				PreparedStatement pst = con.prepareStatement("INSERT INTO scuolacorsi.Studenti (id, nome, "
						+ "cognome, data_di_nascita, CF, email, telefono, città, via, cap, id_regione,"
						+ " titolo_studio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		) {
			pst.setInt(1, studente.getId());
			pst.setString(2, studente.getNome());
			pst.setString(3, studente.getCognome());
			pst.setString(4, studente.getDataDiNascita());
			pst.setString(5, studente.getCF());
			pst.setString(6, studente.getEmail());
			pst.setString(7, studente.getTelefono());
			pst.setString(8, studente.getCittà());
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
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolacorsi", "root",
				"1qaz2wsx");
				PreparedStatement pst = con.prepareStatement("DELETE FROM scuolacorsi.Studenti WHERE id = ?;");

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
	public Collection<Student> findAll() {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolacorsi", "root",
				"1qaz2wsx");
				PreparedStatement pst = con.prepareStatement("SELECT * FROM scuolacorsi.Studenti;");

		) {

			try (ResultSet rs = pst.executeQuery()) {
				rs.next();
				int idStudente = rs.getInt("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String dataDiNascita = rs.getString("data_di_nascita");
				String CF = rs.getString("CF");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				String città = rs.getString("città");
				String via = rs.getString("via");
				String cap = rs.getString("cap");
				int idRegione = rs.getInt("id_regione");
				String titoloStudio = rs.getString("titolo_studio");

				Student st = new Student(idStudente, nome, cognome, dataDiNascita, CF, email, telefono, città, via, cap,
						idRegione, titoloStudio);

				return Optional.ofNullable(st);
			}
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}

		
	}

	@Override
	public Collection<Student> findByNameLike(String partialName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> findByLastNameLike(String partialLastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Student> findById(int id) throws DataException {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolacorsi", "root",
				"1qaz2wsx");
				PreparedStatement pst = con.prepareStatement("SELECT * FROM scuolacorsi.Studenti WHERE id = ?;");

		) {

			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				rs.next();
				int idStudente = rs.getInt("id");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String dataDiNascita = rs.getString("data_di_nascita");
				String CF = rs.getString("CF");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				String città = rs.getString("città");
				String via = rs.getString("via");
				String cap = rs.getString("cap");
				int idRegione = rs.getInt("id_regione");
				String titoloStudio = rs.getString("titolo_studio");

				Student st = new Student(idStudente, nome, cognome, dataDiNascita, CF, email, telefono, città, via, cap,
						idRegione, titoloStudio);

				return Optional.ofNullable(st);
			}
		} catch (SQLException e) {
			throw new DataException(e.getMessage(), e);
		}

	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void iscriviStudente(int studentId, int corsoId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Student> allStudentByCourse(int corsoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
