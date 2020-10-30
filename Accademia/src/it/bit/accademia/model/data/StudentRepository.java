package it.bit.accademia.model.data;

import java.util.Collection;
import java.util.Optional;

import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.Student;

public interface StudentRepository{
		//create, read,update, delete = METODI CRUD
		//principio SRP = single responsability principle
	
	 Student add(Student studente) throws DataException;
	 Student delete(int id) throws DataException, LogicException;
	 Collection<Student> findAll() throws DataException;
	 Collection<Student> findByNameLike(String partialName) throws DataException;
	 Collection<Student> findByLastNameLike(String partialLastname) throws DataException;
	 Optional<Student> findById(int id) throws DataException;
	 void update(Student student) throws DataException;
	 void iscriviStudente(int studentId,int corsoId) throws LogicException;
	 Collection<Student> allStudentByCourse(int corsoId) throws DataException;

}
