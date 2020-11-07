package it.bit.accademia.model.data;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.Student;
import it.bit.accademia.model.data.hibernate.SessionFactoryHolder;

class StudentRepositoryHibernateTest {
	private Student sAdd;
	private Student sDel;
	private Student s;
	private StudentRepositoryHibernate repo;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		sAdd =  new Student(5, "cluadio", "paolino", "20000909", "ciiao"
				, "cldsa@gmail.com", "323712325", "Milano", "via claudio", "21333", 1, "Impiegato");
		sDel = new Student(7, "nome", "cognome", "dataDiNascita", "cF",
				"email", "telefono", "citta", "via", "cap", 1, "titoloStudio");
		repo = new StudentRepositoryHibernate(SessionFactoryHolder.getInstance().openSession() , Student.class);
		insertStudent(sDel);
	}

	@AfterEach
	void tearDown() throws Exception {
		deleteStudentById(sAdd.getId());
		deleteStudentById(sDel.getId());
		repo.close();
	}
	boolean studentExists(int id) {
		try(Session s = SessionFactoryHolder.getInstance().openSession()){
			return s.get(Student.class, id) != null;
		}
	}
	private void deleteStudentById(int id) {
		try(Session s = SessionFactoryHolder.getInstance().openSession()){
			s.getTransaction().begin();
			s.createQuery("delete from Student s where s.id = :id")
				.setParameter("id", id).executeUpdate();
			s.getTransaction().commit();
		}
	}
	private void insertStudent(Student st) {
		try(Session s = SessionFactoryHolder.getInstance().openSession()){
			s.getTransaction().begin();
			s.save(st);
			s.getTransaction().commit();
		}
	}
	private void fullEquals(Student s1, Student s2) {
		if (s1 == s2)
			return;
		assertNotNull(s1);
		assertNotNull(s2);
		assertEquals(s1.getCF(),s2.getCF());
		assertEquals(s1.getCap(),s2.getCap());
		assertEquals(s1.getCitta(),s2.getCitta());
		assertEquals(s1.getCognome(),s2.getCognome());
		assertEquals(s1.getDataDiNascita(),s2.getDataDiNascita());
		assertEquals(s1.getEmail(),s2.getEmail());
		assertEquals(s1.getId(),s2.getId());
		assertEquals(s1.getIdRegione(),s2.getIdRegione());
//		assertEquals(s1.getIscrizioni(),s2.getIscrizioni());
		assertEquals(s1.getNome(),s2.getNome());
		assertEquals(s1.getTelefono(),s2.getTelefono());
		assertEquals(s1.getTitoloStudio(),s2.getTitoloStudio());
		assertEquals(s1.getVia(),s2.getVia());
	}
	
	@Test
	void testAdd() {
		try {
			repo.add(sAdd);
			assertTrue(studentExists(sAdd.getId()));
		} catch (DataException e) {
			fail(e.getMessage());
		}
	}
	@Test
	void testDelete() {
		try {
			repo.delete(sDel.getId());
			assertFalse(studentExists(sDel.getId()));
		} catch (DataException | LogicException e) {
			fail(e.getMessage());
		} 
	}
	@Test
	void testUpdata() {
		try (Session session = SessionFactoryHolder.getInstance().openSession()){
			s = new Student(7, "nome1", "cognome2", "dataDiNascita3", "cF4",
				"email5", "telefono6", "citta7", "via8", "cap12", 1, "titoloStudio3");
			repo.update(s);
			Student updated = session.get(Student.class , 7);
			assertEquals("nome1", updated.getNome());
			assertEquals("cognome2", updated.getCognome());
			assertEquals("cF4", updated.getCF());
		} catch (DataException e) {
			fail(e.getMessage());
		} 
	}
	@Test 
	void testFindById() {
		try {
			Student f = repo.findById(sDel.getId()).get();
//			assertTrue(f.fullEquals(sDel));
			fullEquals(f,sDel);
		} catch (DataException e) {
			fail(e.getMessage());
		} 
	}
}
