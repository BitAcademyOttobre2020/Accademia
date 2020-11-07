package it.bit.accademia;

import it.bit.accademia.model.Student;
import it.bit.accademia.model.data.DataException;
import it.bit.accademia.model.data.StudentRepository;
import it.bit.accademia.model.data.StudentRepositoryHibernate;

public class StudentController {
	private StudentRepository repoHib;
	public StudentController(StudentRepository sr) {
		repoHib = sr;
	}
	public void creaStudente(Student s) throws Exception {
		try {
			repoHib.add(s);
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
