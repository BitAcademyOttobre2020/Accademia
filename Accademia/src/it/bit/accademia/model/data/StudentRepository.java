package it.bit.accademia.model.data;

import java.util.Collection;
import java.util.Optional;

import it.bit.accademia.model.LogicException;
import it.bit.accademia.model.Student;

public interface StudentRepository extends GenericRepository<Student>{
		//create, read,update, delete = METODI CRUD
		//principio SRP = single responsability principle
	 
	 Collection<Student> findByNameLike(String partialName) throws DataException;
	 Collection<Student> findByLastNameLike(String partialLastname) throws DataException;
	 void iscriviStudente(int studentId,int corsoId) throws LogicException;
	 Collection<Student> allStudentByCourse(int corsoId) throws DataException;

}
